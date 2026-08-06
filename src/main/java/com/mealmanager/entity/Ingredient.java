package com.mealmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;


@Entity
public class Ingredient {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @NotBlank
    private String name;

    @PositiveOrZero
    private Double quantity;

    @NotBlank
    private String unit;

    public Ingredient(){

    }

    public Ingredient(String name, Double quantity, String unit){
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }
    public Long getId(){
        return this.id;
    }
    public String getName (){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Double getQuantity(){
        return quantity;
    }
    public void setQuantity(Double quantity){
        this.quantity = quantity;
    }
    public String getUnit(){
        return unit;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }
}