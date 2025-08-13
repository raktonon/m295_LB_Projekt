package com.wiss.cocktailbackend.controller;

import com.wiss.cocktailbackend.dto.*;
import com.wiss.cocktailbackend.service.CocktailService;
import org.springframework.data.domain.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CocktailController {

    private final CocktailService service;
    public CocktailController(CocktailService service) { this.service = service; }

    @GetMapping("/cocktails")
    public Page<CocktailListItemDTO> list(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) String alcoholic, // "Alcoholic" / "Non alcoholic"
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size) {
        return service.list(q, alcoholic, PageRequest.of(page, size, Sort.by("name").ascending()));
    }

    @GetMapping("/cocktails/{id}")
    public CocktailDTO get(@PathVariable Long id) { return service.get(id); }

    @PostMapping("/cocktails")
    public java.util.Map<String, Long> create(@Validated @RequestBody CocktailDTO dto) {
        return java.util.Map.of("id", service.create(dto));
    }

    @PutMapping("/cocktails/{id}")
    public void update(@PathVariable Long id, @Validated @RequestBody CocktailDTO dto) { service.update(id, dto); }

    @DeleteMapping("/cocktails/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}