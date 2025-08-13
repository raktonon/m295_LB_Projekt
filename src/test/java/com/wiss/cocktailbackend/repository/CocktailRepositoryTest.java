package com.wiss.cocktailbackend.repository;

import com.wiss.cocktailbackend.entity.Cocktail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class CocktailRepositoryTest {

    @Autowired
    CocktailRepository repo;

    private void seed() {
        repo.save(make("Mojito", "Alcoholic"));
        repo.save(make("Virgin Mojito", "Non alcoholic"));
        repo.save(make("Margarita", "Alcoholic"));
    }

    private Cocktail make(String name, String alcoholic) {
        var c = new Cocktail();
        c.setName(name);
        c.setAlcoholic(alcoholic);
        c.setCategory("Cocktail");
        c.setGlass("Glass");
        c.setInstructions("Mix");
        c.setImageUrl("https://img");
        return c;
    }

    @Test
    void search_by_name_contains_q() {
        seed();
        var page = repo.search("moj", null, PageRequest.of(0, 10));
        assertEquals(2, page.getTotalElements()); // Mojito + Virgin Mojito
    }

    @Test
    void search_filter_by_alcoholic_exact() {
        seed();
        var page = repo.search(null, "Non alcoholic", PageRequest.of(0, 10));
        assertEquals(1, page.getTotalElements()); // nur Virgin Mojito
        assertEquals("Virgin Mojito", page.getContent().get(0).getName());
    }
}