package com.hv.rickandmorty.characteres.service.infrastructure.web.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerDocumentation {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("RICK-AND-MORTY-CHARACTERS-SERVICE").description(
                        "Rick and morty character finder microservice API doc by OpenAPI 3.").version("1.0.0"));
    }


}
