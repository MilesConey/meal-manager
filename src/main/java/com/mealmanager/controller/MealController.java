package com.mealmanager.controller;

import com.mealmanager.entity.Meal;
import com.mealmanager.service.MealService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService){

        this.mealService = mealService;
    }
    @GetMapping
    public List<Meal> getMeals(@RequestParam(required = false) String category,
                               @RequestParam(required = false) String name){
        if (category != null){
            return mealService.getMealsByCategory(category);}
        else if (name != null) {
            return mealService.getMealsByNameSearch(name);}
        else {
        return mealService.getAllMeals();}
    }

    @PostMapping
    public Meal createMeal(@Valid @RequestBody Meal meal){

        return mealService.saveMeal(meal);
    }
    @GetMapping("/{id}")
    public Meal getMealById(@PathVariable Long id){
        return mealService.getMealById(id);
    }
    @PutMapping("/{id}")
    public Meal updateMeal(@PathVariable Long id, @Valid @RequestBody Meal updatedMeal) {
        return mealService.updateMeal(id, updatedMeal);
    }
    @DeleteMapping("/{id}")
    public void deleteMeal(@PathVariable Long id){
        mealService.deleteMeal(id);
    }
}
