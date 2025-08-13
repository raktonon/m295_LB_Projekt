package com.wiss.cocktailbackend.repository;

import com.wiss.cocktailbackend.entity.CocktailIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailIngredientRepository extends JpaRepository<CocktailIngredient, Long> { }
