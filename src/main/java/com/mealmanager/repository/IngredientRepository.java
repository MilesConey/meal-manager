package com.mealmanager.repository;

import com.mealmanager.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    public List<Ingredient> findIngredientByNameContainingIgnoreCase(String name);
}
