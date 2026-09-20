package com.mealmanager.service;


import com.mealmanager.entity.Ingredient;
import com.mealmanager.entity.Meal;
import com.mealmanager.entity.MealIngredient;
import com.mealmanager.repository.IngredientRepository;
import com.mealmanager.repository.MealIngredientRepository;
import com.mealmanager.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MealIngredientService {

    private final MealIngredientRepository mealIngredientRepository;
    private final MealRepository mealRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public MealIngredientService(MealIngredientRepository mealIngredientRepository, IngredientRepository ingredientRepository, MealRepository mealRepository) {
        this.mealIngredientRepository = mealIngredientRepository;
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<MealIngredient> getAllMealIngredients() {

        return mealIngredientRepository.findAll();
    }

    public MealIngredient getMealIngredientById(Long id) {
        Optional<MealIngredient> mealIngredient = mealIngredientRepository.findById(id);
        if (mealIngredient.isPresent()) {
            return mealIngredient.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meal Ingredient not found");
    }

    public MealIngredient saveMealIngredient(MealIngredient mealIngredient) {

        Meal meal = mealIngredient.getMeal();
        Long mealId = meal.getId();
        Optional<Meal> newMeal = mealRepository.findById(mealId);
        if (newMeal.isPresent()) {
            mealIngredient.setMeal(newMeal.get());
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meal not found");
        Ingredient ingredient = mealIngredient.getIngredient();
        Long ingredientId = ingredient.getId();
        Optional<Ingredient> databaseIngredient = ingredientRepository.findById(ingredientId);
        if (databaseIngredient.isPresent()) {
            mealIngredient.setIngredient(databaseIngredient.get());
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredients not found");
        return mealIngredientRepository.save(mealIngredient);
    }

    public MealIngredient updateMealIngredient(Long id, MealIngredient updatedMealIngredient) {
        MealIngredient existingMealIngredient = getMealIngredientById(id);
        existingMealIngredient.setIngredient(updatedMealIngredient.getIngredient());
        existingMealIngredient.setQuantity(updatedMealIngredient.getQuantity());
        existingMealIngredient.setUnit(updatedMealIngredient.getUnit());
        return mealIngredientRepository.save(existingMealIngredient);
    }

    public void deleteMealIngredientById(Long id) {
        MealIngredient existingMealIngredient = getMealIngredientById(id);
        mealIngredientRepository.delete(existingMealIngredient);
    }
}

