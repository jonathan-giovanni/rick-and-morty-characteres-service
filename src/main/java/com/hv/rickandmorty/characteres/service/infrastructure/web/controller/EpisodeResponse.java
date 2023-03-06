package com.hv.rickandmorty.characteres.service.infrastructure.web.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record EpisodeResponse(
        @Schema(description = "Episode identifier",example = "1")
        @JsonProperty String id,
        @Schema(description = "Episode name",example = "Pilot")
        @JsonProperty String name,
        @Schema(description = "Episode air date",example = "2022-02-26T20:53:04.663Z")
        @JsonProperty LocalDateTime airDate) {

    public EpisodeResponse(){
        this(null,null,null);
    }

    public EpisodeResponse(String id,
                           String name,
                           LocalDateTime airDate) {
        this.id = id;
        this.name = name;
        this.airDate = airDate;
    }
}
