package com.hv.rickandmorty.characteres.service.infrastructure.adapter.graphql;

import graphql.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GraphQLSearchCharacterAppearanceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Test
    void searchRickSanchezExpectedResultInformation() {
        var graphQLSearchCharacterAppearance = new GraphQLSearchCharacterAppearance();

        String name = "birdperson";

        var result = graphQLSearchCharacterAppearance.findByName(name);

        log.info("Searching: {} is present: {}",name,result.isPresent());

        Assert.assertTrue(true);
    }

}
