package org.launchcode.models.forms;

import org.launchcode.models.Ingredient;
import org.launchcode.models.Meal;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


public class AddIngredientItemForm {
    @NotNull
    private int mealId;

    @NotNull
    private int ingredientId;

    private Iterable<Ingredient> ingredients;

    private Meal meal;

    public AddIngredientItemForm(Iterable<Ingredient> ingredients, Meal meal){
        this.meal = meal;
        this.ingredients = ingredients;
    }

    public AddIngredientItemForm(){

    }

    public Iterable<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Iterable<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public int getMealId() {
        return mealId;
    }


    public int getIngredientId() {
        return ingredientId;
    }



}
