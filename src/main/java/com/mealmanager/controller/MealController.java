package com.mealmanager.controller;

import com.mealmanager.entity.Meal;
import com.mealmanager.service.MealService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meals")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService){

        this.mealService = mealService;
    }
    @GetMapping
    public List<Meal> getAllMeals(){

        return mealService.getAllMeals();
    }

    @PostMapping
    public Meal createMeal(@RequestBody Meal meal){

        return mealService.saveMeal(meal);
    }
    @GetMapping("/{id}")
    public Meal getMealById(@PathVariable Long id){
        return mealService.getMealById(id);
    }
}
