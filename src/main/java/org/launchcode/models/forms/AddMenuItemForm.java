package org.launchcode.models.forms;

import org.launchcode.models.Meal;
import org.launchcode.models.Menu;

import javax.validation.constraints.NotNull;

public class AddMenuItemForm {

    @NotNull
    private int menuId;

    @NotNull
    private int mealID;

    private Iterable<Meal> meals;

    private Menu menu;

    public AddMenuItemForm(Iterable<Meal> meals, Menu menu){
        this.meals = meals;
        this.menu = menu;
    }

    public AddMenuItemForm(){}

    public int getMenuId() {
        return menuId;
    }

    public int getMealId() {
        return mealID;
    }

    public void setMealID(int mealID) {
        this.mealID = mealID;
    }

    public Iterable<Meal> getMeals() {
        return meals;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
}
