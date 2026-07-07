package com.mealmanager.service;

import com.mealmanager.entity.Meal;
import com.mealmanager.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service // tells Spring to recognize the class as a Service
public class MealService {
    private MealRepository mealRepository;

    @Autowired // @Autowired tells Spring to satisfy the constructor's dependencies by providing the required objects when creating MealService.
    public MealService (MealRepository mealRepository) {

        this.mealRepository = mealRepository;
    }

    public List<Meal> getAllMeals(){

        return mealRepository.findAll();
    }

    public Meal saveMeal(Meal meal){

        return mealRepository.save(meal);
    }

    public Meal getMealById(Long id){
        Optional<Meal> meal = mealRepository.findById(id);

        if (meal.isPresent()){
            return meal.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meal not found");
    }

    public Meal updateMeal(Long id, Meal updatedMeal){
        Meal existingMeal = getMealById(id);
        existingMeal.setName(updatedMeal.getName());
        existingMeal.setCalories(updatedMeal.getCalories());
        existingMeal.setCategory(updatedMeal.getCategory());
        existingMeal.setDescription(updatedMeal.getDescription());
        return mealRepository.save(existingMeal);
    }
}
