package com.wiss.cocktailbackend.entity;

import jakarta.persistence.*;

@Entity
public class CocktailIngredient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Cocktail cocktail;

    @ManyToOne(optional = false)
    private Ingredient ingredient;

    private String measure;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cocktail getCocktail() { return cocktail; }
    public void setCocktail(Cocktail cocktail) { this.cocktail = cocktail; }
    public Ingredient getIngredient() { return ingredient; }
    public void setIngredient(Ingredient ingredient) { this.ingredient = ingredient; }
    public String getMeasure() { return measure; }
    public void setMeasure(String measure) { this.measure = measure; }
}
