package com.wiss.cocktailbackend.service;

import com.wiss.cocktailbackend.dto.*;
import com.wiss.cocktailbackend.entity.*;
import com.wiss.cocktailbackend.repository.*;
import com.wiss.cocktailbackend.mapper.CocktailMapper;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CocktailService {

    private final CocktailRepository cocktailRepo;
    private final IngredientRepository ingredientRepo;
    private final RatingRepository ratingRepo;

    public CocktailService(CocktailRepository cocktailRepo, IngredientRepository ingredientRepo, RatingRepository ratingRepo) {
        this.cocktailRepo = cocktailRepo;
        this.ingredientRepo = ingredientRepo;
        this.ratingRepo = ratingRepo;
    }

    public Page<CocktailListItemDTO> list(String q, Boolean alcoholic, Pageable pageable) {
        return cocktailRepo.search(q, alcoholic, pageable).map(CocktailMapper::toListItem);
    }

    public CocktailDTO get(Long id) {
        var entity = cocktailRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Cocktail not found"));
        return CocktailMapper.toDto(entity);
    }

    public Long create(CocktailDTO dto) {
        var entity = new Cocktail();
        apply(entity, dto);
        cocktailRepo.save(entity);
        return entity.getId();
    }

    public void update(Long id, CocktailDTO dto) {
        var entity = cocktailRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Cocktail not found"));
        entity.getIngredients().clear();
        apply(entity, dto);
    }

    public void delete(Long id) {
        cocktailRepo.deleteById(id);
    }

    public void addRating(Long id, RatingDTO dto) {
        var cocktail = cocktailRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Cocktail not found"));
        var r = new Rating();
        r.setCocktail(cocktail);
        r.setStars(dto.stars());
        r.setComment(dto.comment());
        ratingRepo.save(r);
    }

    public java.util.List<String> suggestIngredients(String q) {
        if (q == null || q.isBlank()) return java.util.List.of();
        return ingredientRepo.findByNameContainingIgnoreCase(q).stream().map(Ingredient::getName).toList();
    }

    private void apply(Cocktail entity, CocktailDTO dto) {
        entity.setName(dto.name);
        entity.setCategory(dto.category);
        entity.setAlcoholic(dto.alcoholic);
        entity.setInstructions(dto.instructions);
        entity.setThumbnailUrl(dto.thumbnailUrl);

        for (var line : dto.ingredients) {
            var ing = ingredientRepo.findByNameIgnoreCase(line.name).orElseGet(() -> ingredientRepo.save(new Ingredient(line.name)));
            var ci = new CocktailIngredient();
            ci.setCocktail(entity);
            ci.setIngredient(ing);
            ci.setMeasure(line.measure);
            entity.getIngredients().add(ci);
        }
    }
}
