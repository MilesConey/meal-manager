package com.mealmanager.repository;

import com.mealmanager.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository <Meal, Long> {
    public List<Meal> findByCategory(String category);
    public List<Meal> findByNameContainingIgnoreCase(String name);
}
