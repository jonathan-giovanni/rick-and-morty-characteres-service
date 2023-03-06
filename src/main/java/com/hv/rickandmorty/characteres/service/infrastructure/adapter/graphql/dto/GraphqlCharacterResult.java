package com.hv.rickandmorty.characteres.service.infrastructure.adapter.graphql.dto;

import java.util.List;

public record GraphqlCharacterResult(String id, String name, String species, String gender, String image,
                                     List<GraphqlEpisode> episode) {
}
