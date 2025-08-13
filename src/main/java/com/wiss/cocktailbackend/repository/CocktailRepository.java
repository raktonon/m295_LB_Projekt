package com.wiss.cocktailbackend.repository;

import com.wiss.cocktailbackend.entity.Cocktail;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

    @Query("""
     select c from Cocktail c
     where (:q is null or :q = '' or lower(c.name) like concat('%', lower(:q), '%'))
       and (:alcoholic is null or :alcoholic = '' or lower(c.alcoholic) = lower(:alcoholic))
  """)
    Page<Cocktail> search(@Param("q") String q,
                          @Param("alcoholic") String alcoholic,
                          Pageable pageable);
}
