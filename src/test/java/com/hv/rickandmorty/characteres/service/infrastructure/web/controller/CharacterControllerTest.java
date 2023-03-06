package com.hv.rickandmorty.characteres.service.infrastructure.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class CharacterControllerTest {


    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ObjectMapper mapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();


    @Autowired
    private MockMvc mockMvc;

    private CharacterResponse call_get_method_and_get_character_response(String name) throws Exception {
        log.info("Test with character name: {} ",name);
        var result = mockMvc.perform(get("/api/v1/rick-and-morty/search-character-appearance?name="+name)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        var object = mapper.readValue(result.getResponse().getContentAsString(),CharacterResponse.class);

        log.info("object: {}",object);
        return object;
    }

    private ErrorResponse call_get_method_and_get_error_response(String name) throws Exception {
        log.info("Test with character name: {} ",name);
        var result = mockMvc.perform(get("/api/v1/rick-and-morty/search-character-appearance?name="+name)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()).andReturn();

        var object = mapper.readValue(result.getResponse().getContentAsString(),ErrorResponse.class);

        log.info("object: {}",object);
        return object;
    }



    @Test
    void test01Request_rick_sanchez_and_expect_ok_with_data() throws Exception {
        var name = "rick sanchez";

        var priceResponse = call_get_method_and_get_character_response(name);

        Assertions.assertNotNull(priceResponse);
    }

    @Test
    void test02Request_jonathan_hernandez_and_expect_is_not_found() throws Exception {
        var name = "jonathan hernandez";

        var priceResponse = call_get_method_and_get_error_response(name);

        Assertions.assertNotNull(priceResponse);
    }

}
