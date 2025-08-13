package com.wiss.cocktailbackend.dto;

import jakarta.validation.constraints.*;

public record RatingDTO(@Min(1) @Max(5) int stars, @Size(max = 1000) String comment) {}
