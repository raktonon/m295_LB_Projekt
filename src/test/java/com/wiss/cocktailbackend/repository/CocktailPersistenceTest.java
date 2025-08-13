package com.wiss.cocktailbackend.repository;

import com.wiss.cocktailbackend.entity.Cocktail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class CocktailPersistenceTest {

    @Autowired
    CocktailRepository repo;

    @Test
    void save_and_load_cocktail_fields() {
        var e = new Cocktail();
        e.setName("Colada");
        e.setCategory("Cocktail");
        e.setAlcoholic("Alcoholic");
        e.setGlass("Hurricane glass");
        e.setInstructions("Blend");
        e.setImageUrl("https://img");

        var saved = repo.save(e);
        var reloaded = repo.findById(saved.getId()).orElseThrow();

        assertEquals("Colada", reloaded.getName());
        assertEquals("Cocktail", reloaded.getCategory());
        assertEquals("Alcoholic", reloaded.getAlcoholic());
        assertEquals("Hurricane glass", reloaded.getGlass());
        assertEquals("Blend", reloaded.getInstructions());
        assertEquals("https://img", reloaded.getImageUrl());
    }
}