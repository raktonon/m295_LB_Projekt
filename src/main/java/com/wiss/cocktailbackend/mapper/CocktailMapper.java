package com.wiss.cocktailbackend.mapper;

import com.wiss.cocktailbackend.dto.CocktailDTO;
import com.wiss.cocktailbackend.dto.CocktailListItemDTO;
import com.wiss.cocktailbackend.entity.Cocktail;

public class CocktailMapper {

    public static CocktailDTO toDto(Cocktail e) {
        var dto = new CocktailDTO();
        dto.id = e.getId();
        dto.name = e.getName();
        dto.category = e.getCategory();
        dto.alcoholic = e.getAlcoholic();
        dto.glass = e.getGlass();
        dto.instructions = e.getInstructions();
        dto.imageUrl = e.getImageUrl();
        return dto;
    }

    public static void apply(Cocktail e, CocktailDTO dto) {
        e.setName(dto.name);
        e.setCategory(dto.category);
        e.setAlcoholic(dto.alcoholic);
        e.setGlass(dto.glass);
        e.setInstructions(dto.instructions);
        e.setImageUrl(dto.imageUrl);
    }

    public static CocktailListItemDTO toListItem(Cocktail e) {
        return new CocktailListItemDTO(
                e.getId(),
                e.getName(),
                e.getAlcoholic(),
                e.getImageUrl()
        );
    }
}