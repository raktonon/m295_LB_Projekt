package com.wiss.cocktailbackend.mapper;

import com.wiss.cocktailbackend.dto.*;
import com.wiss.cocktailbackend.entity.*;

public class CocktailMapper {

    public static CocktailDTO toDto(Cocktail entity) {
        var dto = new CocktailDTO();
        dto.id = entity.getId();
        dto.name = entity.getName();
        dto.category = entity.getCategory();
        dto.alcoholic = entity.isAlcoholic();
        dto.instructions = entity.getInstructions();
        dto.thumbnailUrl = entity.getThumbnailUrl();
        var list = new java.util.ArrayList<CocktailDTO.IngredientLine>();
        for (var ci : entity.getIngredients()) {
            list.add(new CocktailDTO.IngredientLine(ci.getIngredient().getName(), ci.getMeasure()));
        }
        dto.ingredients = list;
        return dto;
    }

    public static CocktailListItemDTO toListItem(Cocktail entity) {
        var names = entity.getIngredients().stream().map(ci -> ci.getIngredient().getName()).toList();
        return new CocktailListItemDTO(entity.getId(), entity.getName(), entity.isAlcoholic(), entity.getThumbnailUrl(), names);
    }
}
