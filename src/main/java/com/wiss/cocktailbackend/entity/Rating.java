package com.wiss.cocktailbackend.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class Rating {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Cocktail cocktail;

    @Column(nullable = false)
    private int stars;

    @Column(length = 1000)
    private String comment;

    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cocktail getCocktail() { return cocktail; }
    public void setCocktail(Cocktail cocktail) { this.cocktail = cocktail; }
    public int getStars() { return stars; }
    public void setStars(int stars) { this.stars = stars; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
