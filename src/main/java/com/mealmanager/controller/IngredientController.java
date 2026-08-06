package com.mealmanager.controller;

import com.mealmanager.entity.Ingredient;
import com.mealmanager.service.IngredientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){

        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getAllIngredients(){

        return ingredientService.getAllIngredients();
    }

    @PostMapping
    public Ingredient createIngredient(@Valid @RequestBody Ingredient ingredient){

        return ingredientService.saveIngredient(ingredient);
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id){

        return ingredientService.getIngredientById(id);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable Long id, @Valid @RequestBody Ingredient updatedIngredient){

        return ingredientService.updateIngredient(id, updatedIngredient);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id){

        ingredientService.deleteIngredient(id);
    }
}
