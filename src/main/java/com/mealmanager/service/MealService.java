package com.mealmanager.service;

import com.mealmanager.entity.Meal;
import com.mealmanager.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


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

}
