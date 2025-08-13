package com.wiss.cocktailbackend.dto;

import java.util.List;

public record CocktailListItemDTO(Long id, String name, boolean alcoholic, String thumbnailUrl, java.util.List<String> ingredients) {}
