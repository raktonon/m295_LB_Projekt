package com.wiss.cocktailbackend.dto;

import jakarta.validation.constraints.*;

public class CocktailDTO {
    public Long id;

    @NotBlank public String name;
    public String category;
    /** "Alcoholic" oder "Non alcoholic" wie im Frontend */
    public String alcoholic;
    public String glass;

    @Size(max = 4000)
    public String instructions;

    public String imageUrl;
}