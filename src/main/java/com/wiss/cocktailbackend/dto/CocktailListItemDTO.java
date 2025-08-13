package com.wiss.cocktailbackend.dto;

public record CocktailListItemDTO(
        Long id,
        String name,
        String alcoholic,
        String imageUrl
) {}