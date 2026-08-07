package com.mealmanager.service;

import com.mealmanager.entity.Ingredient;
import com.mealmanager.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public  IngredientService (IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }
    public List<Ingredient> getAllIngredients(){
        return ingredientRepository.findAll();
    }
    public  Ingredient saveIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }
    public Ingredient getIngredientById(Long id){
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);

        if (ingredient.isPresent()){
            return ingredient.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found");
    }
    public Ingredient updateIngredient(Long id, Ingredient updatedIngredient){
        Ingredient existingIngredient = getIngredientById(id);
        existingIngredient.setName(updatedIngredient.getName());
        existingIngredient.setQuantity(updatedIngredient.getQuantity());
        existingIngredient.setUnit(updatedIngredient.getUnit());
        return ingredientRepository.save(existingIngredient);
    }
    public void deleteIngredient(Long id){
        Ingredient existingIngredient = getIngredientById(id);
        ingredientRepository.delete(existingIngredient);
    }
    public List<Ingredient> getIngredientsByNameSearch(String name){
        return ingredientRepository.findIngredientByNameContainingIgnoreCase(name);
    }
}
