package com.wiss.cocktailbackend.repository;

import com.wiss.cocktailbackend.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByNameIgnoreCase(String name);
    List<Ingredient> findByNameContainingIgnoreCase(String name);
}
