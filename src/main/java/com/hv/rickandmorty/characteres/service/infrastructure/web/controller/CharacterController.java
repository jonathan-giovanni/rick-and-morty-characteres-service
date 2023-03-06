package com.hv.rickandmorty.characteres.service.infrastructure.web.controller;


import com.hv.rickandmorty.characteres.service.application.SearchCharacterByName;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/rick-and-morty/")
public class CharacterController {

    private final SearchCharacterByName searchCharacterByName;

    public CharacterController(SearchCharacterByName searchCharacterByName) {
        this.searchCharacterByName = searchCharacterByName;
    }

    @Operation(summary="Get the rick and morty character",description="Get the rick and morty character with all the episodes that appear")
    @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterResponse.class)))
    @ApiResponse(responseCode = "404", description = "Character Not Found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    @GetMapping("/search-character-appearance")
    public ResponseEntity<CharacterResponse> findCharacterResponse(@RequestParam String name) {
        var data = searchCharacterByName.execute(name);
        return new ResponseEntity<>(new CharacterResponse(
                data.id(),
                data.name(),
                data.species(),
                data.gender(),
                data.image(),
                data.firsAppearance(),
                data.episodes().stream().map(e-> new EpisodeResponse(e.id(),e.name(),e.airDate())).toList()
        ), HttpStatus.OK);
    }


}
