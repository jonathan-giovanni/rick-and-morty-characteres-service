package com.hv.rickandmorty.characteres.service.application;

import com.hv.rickandmorty.characteres.service.domain.exception.CharacterNotFoundException;
import com.hv.rickandmorty.characteres.service.domain.model.Character;
import com.hv.rickandmorty.characteres.service.domain.port.SearchCharacterAppearanceRepository;
import org.springframework.stereotype.Component;

@Component
public class SearchCharacterByName {

    private final SearchCharacterAppearanceRepository searchCharacterAppearanceRepository;

    public SearchCharacterByName(SearchCharacterAppearanceRepository searchCharacterAppearanceRepository) {
        this.searchCharacterAppearanceRepository = searchCharacterAppearanceRepository;
    }

    public Character execute(String name){
        return searchCharacterAppearanceRepository.findByName(name).orElseThrow(CharacterNotFoundException::new);
    }
}
