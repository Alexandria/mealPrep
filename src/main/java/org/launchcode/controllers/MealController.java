package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.Ingredient;
import org.launchcode.models.Meal;
import org.launchcode.models.data.CategoryDao;
import org.launchcode.models.data.IngredientDAO;
import org.launchcode.models.data.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("meal")
public class MealController {

    @Autowired
    MealDao mealDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    IngredientDAO ingredientDAO;

    // Request path: /meal
    @RequestMapping(value = "")
    public String index(Model model) {
        // will return all of the cheeses in an iterable
        model.addAttribute("meals", mealDao.findAll());
        model.addAttribute("title", "Meal List");

        return "meal/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Meal");
        model.addAttribute(new Meal());
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("ingredients", ingredientDAO.findAll());

        return "meal/add";
    }

    // The controller is creating a  new meal object
    //then adding the new object to mealDao
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute  @Valid Meal newMeal,
                                       Errors errors, Model model, @RequestParam int categoryId
                                        )
    {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Meal");
            model.addAttribute("categories", categoryDao.findAll());
            return "meal/add";
        }

        //This save method is provided by CRUD interface
        Category cat= categoryDao.findOne(categoryId);



        newMeal.setCategory(cat);
        mealDao.save(newMeal);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", mealDao.findAll());
        model.addAttribute("title", "Remove Meal");
        return "meal/remove";
    }

//    @RequestMapping(value = "remove", method = RequestMethod.POST)
//    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {
//
//        for (int cheeseId : cheeseIds) {
//            // .delete() is also from the CRUD repository
//            mealDao.delete(cheeseId);
//        }
//
//        return "redirect:";
//    }



}
