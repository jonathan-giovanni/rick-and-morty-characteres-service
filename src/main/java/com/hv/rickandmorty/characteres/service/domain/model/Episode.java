package com.hv.rickandmorty.characteres.service.domain.model;

import java.time.LocalDateTime;

public record Episode(String id, String name, LocalDateTime airDate) {
}
