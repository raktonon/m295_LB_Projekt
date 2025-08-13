package com.wiss.cocktailbackend.service;

import com.wiss.cocktailbackend.dto.*;
import com.wiss.cocktailbackend.entity.Cocktail;
import com.wiss.cocktailbackend.mapper.CocktailMapper;
import com.wiss.cocktailbackend.repository.CocktailRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
public class CocktailService {

    private final CocktailRepository cocktailRepo;

    public CocktailService(CocktailRepository cocktailRepo) {
        this.cocktailRepo = cocktailRepo;
    }

    public Page<CocktailListItemDTO> list(String q, String alcoholic, Pageable pageable) {
        return cocktailRepo.search(q, alcoholic, pageable).map(CocktailMapper::toListItem);
    }

    public CocktailDTO get(Long id) {
        var e = cocktailRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Cocktail not found"));
        return CocktailMapper.toDto(e);
    }

    public Long create(CocktailDTO dto) {
        var e = new Cocktail();
        CocktailMapper.apply(e, dto);
        cocktailRepo.save(e);
        return e.getId();
    }

    public void update(Long id, CocktailDTO dto) {
        var e = cocktailRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Cocktail not found"));
        CocktailMapper.apply(e, dto);
    }

    public void delete(Long id) {
        cocktailRepo.deleteById(id);
    }
}