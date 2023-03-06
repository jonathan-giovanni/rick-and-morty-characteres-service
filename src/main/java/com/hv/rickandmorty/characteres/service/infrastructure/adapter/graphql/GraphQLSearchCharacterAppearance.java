package com.hv.rickandmorty.characteres.service.infrastructure.adapter.graphql;

import com.hv.rickandmorty.characteres.service.domain.port.SearchCharacterAppearanceRepository;
import com.hv.rickandmorty.characteres.service.infrastructure.adapter.graphql.dto.GraphqlRequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@Component
public class GraphQLSearchCharacterAppearance implements SearchCharacterAppearanceRepository {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String query = "{characters ( filter : {name: \"CHARACTER_NAME\" } ) {results{id,name,species,gender,image,episode{id,name,air_date,}}}}";
    private static final String url = "https://rickandmortyapi.com/graphql";
    @Override
    public Optional<Character> findByName(String name) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type", "application/json");

            var request = "{characters ( filter : {name:\"birdperson\"} ) {results{id,name,species,gender,image,episode{id,name,air_date,}}}}";
            var requestBody = new GraphqlRequestBody(request,null);

            ResponseEntity<String> response = restTemplate.postForEntity(url, new HttpEntity<>(requestBody, headers), String.class);
            log.info("response: {}",response.getBody());

        }catch (Exception ex){
            ex.printStackTrace();
            log.error("ERROR FIND CHARACTER BY NAME: {} - MSG: {}",name,ex.getMessage());
        }
        return Optional.empty();
    }
}
