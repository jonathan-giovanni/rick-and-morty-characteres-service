package com.hv.rickandmorty.characteres.service.infrastructure.adapter.graphql.dto;

import java.util.List;

public record GraphqlCharacter (List<GraphqlCharacterResult> results){
}
