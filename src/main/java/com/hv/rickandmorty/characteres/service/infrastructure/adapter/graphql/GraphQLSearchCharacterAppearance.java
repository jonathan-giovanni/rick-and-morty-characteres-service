package com.hv.rickandmorty.characteres.service.infrastructure.adapter.graphql;

import com.hv.rickandmorty.characteres.service.domain.port.SearchCharacterAppearanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@Component
public class GraphQLSearchCharacterAppearance implements SearchCharacterAppearanceRepository {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Override
    public Optional<Character> findByName(String name) {

        try {

            RestTemplate restTemplate = new RestTemplate();

        }catch (Exception ex){

        }

        return Optional.empty();
    }
}
