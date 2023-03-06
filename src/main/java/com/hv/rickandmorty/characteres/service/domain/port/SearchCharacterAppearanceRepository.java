package com.hv.rickandmorty.characteres.service.domain.port;

import java.util.Optional;

public interface SearchCharacterAppearanceRepository {
    Optional<Character> findByName(String name);
}
