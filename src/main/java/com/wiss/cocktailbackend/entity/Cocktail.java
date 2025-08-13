package com.wiss.cocktailbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cocktails")
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)      private String name;
    @Column(length = 100)          private String category;
    @Column(length = 50)           private String alcoholic;   // e.g. "Alcoholic" / "Non alcoholic"
    @Column(length = 100)          private String glass;
    @Column(length = 4000)         private String instructions;
    @Column(name = "image_url")    private String imageUrl;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getAlcoholic() { return alcoholic; }
    public void setAlcoholic(String alcoholic) { this.alcoholic = alcoholic; }
    public String getGlass() { return glass; }
    public void setGlass(String glass) { this.glass = glass; }
    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
