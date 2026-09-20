package com.mealmanager.repository;

import com.mealmanager.entity.MealIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealIngredientRepository extends JpaRepository<MealIngredient, Long> {

}
