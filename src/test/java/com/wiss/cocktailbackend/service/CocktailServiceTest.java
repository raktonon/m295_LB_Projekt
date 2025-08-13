package com.wiss.cocktailbackend.service;

import com.wiss.cocktailbackend.repository.CocktailRepository;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CocktailServiceTest {

    private final CocktailRepository repo = mock(CocktailRepository.class);
    private final CocktailService service = new CocktailService(repo);

    @Test
    void get_throws_when_not_found() {
        when(repo.findById(999L)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> service.get(999L));
    }
}