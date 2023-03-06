package com.hv.rickandmorty.characteres.service.domain.port;

import com.hv.rickandmorty.characteres.service.domain.model.Character;

import java.util.Optional;

public interface SearchCharacterAppearanceRepository {
    Optional<Character> findByName(String name);
}
