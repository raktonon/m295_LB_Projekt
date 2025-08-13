package com.wiss.cocktailbackend.mapper;

import com.wiss.cocktailbackend.dto.CocktailDTO;
import com.wiss.cocktailbackend.dto.CocktailListItemDTO;
import com.wiss.cocktailbackend.entity.Cocktail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CocktailMapperTest {

    @Test
    void toDto_maps_all_fields() {
        var e = new Cocktail();
        e.setId(7L);
        e.setName("Margarita");
        e.setCategory("Ordinary Drink");
        e.setAlcoholic("Alcoholic");
        e.setGlass("Cocktail glass");
        e.setInstructions("Shake");
        e.setImageUrl("https://img");

        CocktailDTO dto = CocktailMapper.toDto(e);

        assertEquals(7L, dto.id);
        assertEquals("Margarita", dto.name);
        assertEquals("Ordinary Drink", dto.category);
        assertEquals("Alcoholic", dto.alcoholic);
        assertEquals("Cocktail glass", dto.glass);
        assertEquals("Shake", dto.instructions);
        assertEquals("https://img", dto.imageUrl);
    }

    @Test
    void apply_writes_all_fields_to_entity() {
        var dto = new CocktailDTO();
        dto.name = "Virgin Mojito";
        dto.category = "Mocktail";
        dto.alcoholic = "Non alcoholic";
        dto.glass = "Highball glass";
        dto.instructions = "Stir";
        dto.imageUrl = "https://img2";

        var e = new Cocktail();
        CocktailMapper.apply(e, dto);

        assertEquals("Virgin Mojito", e.getName());
        assertEquals("Mocktail", e.getCategory());
        assertEquals("Non alcoholic", e.getAlcoholic());
        assertEquals("Highball glass", e.getGlass());
        assertEquals("Stir", e.getInstructions());
        assertEquals("https://img2", e.getImageUrl());
    }

    @Test
    void toListItem_minimal_projection() {
        var e = new Cocktail();
        e.setId(1L);
        e.setName("Mojito");
        e.setAlcoholic("Alcoholic");
        e.setImageUrl("https://thumb");

        CocktailListItemDTO li = CocktailMapper.toListItem(e);

        assertEquals(1L, li.id());
        assertEquals("Mojito", li.name());
        assertEquals("Alcoholic", li.alcoholic());
        assertEquals("https://thumb", li.imageUrl());
    }
}