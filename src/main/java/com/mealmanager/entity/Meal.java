package com.mealmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity

public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    private String description;

    private String category;
    @PositiveOrZero
    private Integer calories;

    public Meal(){
    }

    public Meal(String name,String description, String category, Integer calories ){
        this.name = name;
        this.description = description;
        this.category = category;
        this.calories = calories;
    }
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    };

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public Integer getCalories(){
        return calories;
    }
    public void setCalories(Integer calories){
        this.calories = calories;
    }

}

