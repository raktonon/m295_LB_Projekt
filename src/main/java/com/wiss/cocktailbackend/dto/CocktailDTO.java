package com.wiss.cocktailbackend.dto;

import jakarta.validation.constraints.*;
import java.util.List;

public class CocktailDTO {
    public Long id;
    @NotBlank public String name;
    public String category;
    public boolean alcoholic;
    @Size(max = 4000) public String instructions;
    public String thumbnailUrl;
    @NotNull @Size(min = 1) public List<IngredientLine> ingredients;

    public static class IngredientLine {
        @NotBlank public String name;
        @Size(max = 50) public String measure;
        public IngredientLine() {}
        public IngredientLine(String name, String measure) { this.name = name; this.measure = measure; }
    }
}
