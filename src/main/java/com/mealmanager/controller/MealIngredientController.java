package com.mealmanager.controller;

import com.mealmanager.entity.MealIngredient;
import com.mealmanager.service.MealIngredientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mealIngredients")
public class MealIngredientController {
    private final MealIngredientService mealIngredientService;

    public MealIngredientController (MealIngredientService mealIngredientService){
        this.mealIngredientService = mealIngredientService;
    }
    @GetMapping
    public List<MealIngredient> getAllMealIngredients(){
        return mealIngredientService.getAllMealIngredients();
    }
    @GetMapping("/{id}")
    public MealIngredient getMealIngredientById(@PathVariable Long id){
        return mealIngredientService.getMealIngredientById(id);
    }
    @PostMapping
    public MealIngredient createMealIngredient(@Valid @RequestBody MealIngredient mealIngredient){
        return mealIngredientService.saveMealIngredient(mealIngredient);
    }
    @PutMapping("/{id}")
    public MealIngredient updateMealIngredient(@PathVariable Long id, @Valid @RequestBody MealIngredient mealIngredient){
        return mealIngredientService.updateMealIngredient(id, mealIngredient);
    }
    @DeleteMapping("/{id}")
    public void deleteMealIngredientById(@PathVariable Long id) {
        mealIngredientService.deleteMealIngredientById(id);
    }
}
