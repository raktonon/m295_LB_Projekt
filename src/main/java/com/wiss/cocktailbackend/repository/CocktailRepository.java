package com.wiss.cocktailbackend.repository;

import com.wiss.cocktailbackend.entity.Cocktail;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
    @Query("select c from Cocktail c where (:q is null or lower(c.name) like lower(concat('%', :q, '%'))) and (:alcoholic is null or c.alcoholic = :alcoholic)")
    Page<Cocktail> search(@Param("q") String q, @Param("alcoholic") Boolean alcoholic, Pageable pageable);
}
