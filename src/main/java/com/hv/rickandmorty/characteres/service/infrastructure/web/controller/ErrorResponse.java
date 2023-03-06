package com.hv.rickandmorty.characteres.service.infrastructure.web.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record ErrorResponse(
        @Schema(description = "Error type",example = "about:blank")
        @JsonProperty String type,
        @Schema(description = "Error title",example = "Price not found")
        @JsonProperty String title,
        @Schema(description = "Error status code",example = "404")
        @JsonProperty Integer status,

        @Schema(description = "Error detail",example = "Price not found with the given id")
        @JsonProperty String detail,
        @Schema(description = "Requested path",example = "/v1/price/")
        @JsonProperty String instance
) {
    public ErrorResponse(String type,String title,Integer status, String detail, String instance) {
        this.type = type;
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.instance = instance;
    }

}
