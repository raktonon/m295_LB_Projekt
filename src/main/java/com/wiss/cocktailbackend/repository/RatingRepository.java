package com.wiss.cocktailbackend.repository;

import com.wiss.cocktailbackend.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    long countByCocktail_Id(Long cocktailId);
    java.util.List<Rating> findByCocktail_Id(Long cocktailId);
}
