package com.wiss.cocktailbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiss.cocktailbackend.dto.CocktailDTO;
import com.wiss.cocktailbackend.dto.CocktailListItemDTO;
import com.wiss.cocktailbackend.service.CocktailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CocktailController.class)
@ActiveProfiles("test")
class CocktailControllerCrudTest {

    @Autowired MockMvc mvc;
    @MockBean CocktailService service;
    @Autowired ObjectMapper om;

    @Test
    void list_returns_page_structure() throws Exception {
        var li = new CocktailListItemDTO(1L, "Mojito", "Alcoholic", "https://img");
        when(service.list(any(), any(), any(PageRequest.class)))
                .thenReturn(new PageImpl<>(List.of(li)));

        mvc.perform(get("/api/cocktails"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").value("Mojito"))
                .andExpect(jsonPath("$.totalElements").value(1));
    }

    @Test
    void create_validates_and_returns_id() throws Exception {
        var dto = new CocktailDTO();
        dto.name = "Newtail";
        dto.alcoholic = "Alcoholic";

        when(service.create(any(CocktailDTO.class))).thenReturn(10L);

        mvc.perform(post("/api/cocktails")
                        .contentType("application/json")
                        .content(om.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(content().json(om.writeValueAsString(Map.of("id", 10L))));
    }

    @Test
    void create_bad_request_on_empty_name() throws Exception {
        var dto = new CocktailDTO(); // name null -> @NotBlank greift

        mvc.perform(post("/api/cocktails")
                        .contentType("application/json")
                        .content(om.writeValueAsString(dto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("VALIDATION_FAILED"));
    }
}