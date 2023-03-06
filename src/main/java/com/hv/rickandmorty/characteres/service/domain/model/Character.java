package com.hv.rickandmorty.characteres.service.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public record Character(String id, String name, String species, String gender, String image, LocalDateTime firsAppearance, List<Episode> episodes) {

}
