package com.hv.rickandmorty.characteres.service.infrastructure.web.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record CharacterResponse(
        @Schema(description = "Character identifier",example = "1")
        @JsonProperty String id,
        @Schema(description = "Character name",example = "Ricky")
        @JsonProperty String name,
        @Schema(description = "Character specimen",example = "Human")
        @JsonProperty String species,
        @Schema(description = "Character gender",example = "Male")
        @JsonProperty String gender,
        @Schema(description = "Character image",example = "https://rickandmortyapi.com/api/character/avatar/47.jpeg")
        @JsonProperty String image,
        @Schema(description = "Character name",example = "2022-02-26T20:53:04.663Z")
        @JsonProperty LocalDateTime firsAppearance,
        @Schema(description = "List of all episodes that appear")
        @JsonProperty List<EpisodeResponse> episodes
) {
    public CharacterResponse(){
        this(null,null,null,null,null,null,null);
    }

    public CharacterResponse(String id,
                             String name,
                             String species,
                             String gender,
                             String image,
                             LocalDateTime firsAppearance,
                             List<EpisodeResponse> episodes) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.image = image;
        this.firsAppearance = firsAppearance;
        this.episodes = episodes;
    }
}
