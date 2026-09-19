package com.mealmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class MealIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Meal meal;
    @ManyToOne
    private Ingredient ingredient;
    @PositiveOrZero
    private Double quantity;
    @NotBlank
    private String unit;

    public MealIngredient(){

    }

    public MealIngredient(Meal meal, Ingredient ingredient, Double quantity, String unit){
        this.meal = meal;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unit = unit;
    }
    public Long getId(){
        return id;
    }
    public Meal getMeal() {
        return meal;
    }
    public Ingredient getIngredient(){
        return ingredient;
    }
    public void setIngredient(Ingredient ingredient){
        this.ingredient = ingredient;
    }

    public void setMeal(Meal meal){
        this.meal = meal;
    }
    public Double getQuantity() {
        return quantity;
    }
    public void setQuantity(Double quantity){
        this.quantity = quantity;
    }
    public String getUnit (){
        return unit;
    }
    public void setUnit (String unit){
        this.unit = unit;
    }
}
