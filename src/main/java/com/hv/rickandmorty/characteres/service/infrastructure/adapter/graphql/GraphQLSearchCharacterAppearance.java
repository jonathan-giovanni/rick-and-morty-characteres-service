package com.hv.rickandmorty.characteres.service.infrastructure.adapter.graphql;

import com.hv.rickandmorty.characteres.service.domain.model.Character;
import com.hv.rickandmorty.characteres.service.domain.model.Episode;
import com.hv.rickandmorty.characteres.service.domain.port.SearchCharacterAppearanceRepository;
import com.hv.rickandmorty.characteres.service.infrastructure.adapter.graphql.dto.GraphqlRequestBody;
import com.hv.rickandmorty.characteres.service.infrastructure.adapter.graphql.dto.GraphqlResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;
import java.util.Optional;


@Component
public class GraphQLSearchCharacterAppearance implements SearchCharacterAppearanceRepository {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String query = "{characters ( filter : {name: \"CHARACTER_NAME\" } ) {results{id,name,species,gender,image,episode{id,name,air_date,}}}}";
    private static final String url = "https://rickandmortyapi.com/graphql";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, u", Locale.ENGLISH);


    /**
     * Calling https://rickandmortyapi.com/graphql with GraphQL method
     * <br> Parsing data to Optional
     * @param name
     * @return
     */
    @Override
    public Optional<Character> findByName(String name) {
        try {
            //prepare rest template
            RestTemplate restTemplate = new RestTemplate();

            //adding content-type headers
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type", "application/json");

            //replace CHARACTER_NAME with variable -> name
            var requestBody = new GraphqlRequestBody(query.replace("CHARACTER_NAME",name),null);

            //calling with post method and parsing to GraphqlResponseBody
            var response = restTemplate.postForEntity(url, new HttpEntity<>(requestBody, headers), GraphqlResponseBody.class);

            //if not a success response return Optional.empty()
            if(!response.getStatusCode().is2xxSuccessful()){
                return Optional.empty();
            }

            //get results and find the first
            var result = response.getBody().data().characters().results().stream().findFirst();
            //if result is empty return Optional.empty()
            if(result.isEmpty()){
                return Optional.empty();
            }

            //obtain data from optional
            var characterFound = result.get();

            //map episodes
            var episodes = characterFound.episode().stream().map(e-> new Episode(e.id(),e.name(), LocalDate.parse(e.air_date(),formatter).atStartOfDay())).toList();

            //get first appearance
            var firstAppearance = episodes.stream().min(Comparator.comparing(Episode::airDate));
            //if result is empty return Optional.empty()
            if(firstAppearance.isEmpty()){
                return Optional.empty();
            }

            //mapping data
            return Optional.of(
                    new Character(
                            characterFound.id(),
                            characterFound.name(),
                            characterFound.species(),
                            characterFound.gender(),
                            characterFound.image(),
                            firstAppearance.get().airDate(),
                            episodes
                    )
            );
        }catch (Exception ex){
            ex.printStackTrace();
            log.error("ERROR FIND CHARACTER BY NAME: {} - MSG: {}",name,ex.getMessage());
        }
        return Optional.empty();
    }
}
