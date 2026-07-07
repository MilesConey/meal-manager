package com.mealmanager.entity; // serves as a unique address for the class to help organize and prevent issues with same class naming

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.io.ObjectInputStream;

@Entity // tells Hibernate, this class will become a table. Without, it's just a regular class.

public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue(strategy = GenerationType.IDENTITY) tells JPA to use the database's auto-increment/identity mechanism to generate primary key values automatically.
    private Long id; // Using Long object type instead of long primitive to allow for null values;
    @NotBlank
    private String name;

    private String description;

    private String category;
    @PositiveOrZero
    private Integer calories;

    public Meal(){
    }

    public Meal(String name,String descriptionName, String category, Integer calories ){
        this.name = name;
        this.description = descriptionName;
        this.category = category;
        this.calories = calories;
    }
//Getters & Setters
    public Long getId(){
        return id;
    }
    // Name cluster
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    };
    //Description cluster
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    //Category cluster
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    //Calorie cluster
    public Integer getCalories(){
        return calories;
    }
    public void setCalories(Integer calories){
        this.calories = calories;
    }

}

