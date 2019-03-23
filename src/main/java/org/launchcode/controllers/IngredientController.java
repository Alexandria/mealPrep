package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.Ingredient;
import org.launchcode.models.data.IngredientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@RequestMapping("ingredient")
@Controller
public class IngredientController {

    @Autowired
    private IngredientDAO ingredientDAO;


    @RequestMapping(value="", method = RequestMethod.GET)
    public String index( Model model){
        model.addAttribute("title", "Ingredient List");
        model.addAttribute("ingredients", ingredientDAO.findAll());

        return "ingredient/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new Ingredient()); //key is "category"
        model.addAttribute("title", "Add Ingredient");
        return "Ingredient/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Ingredient ingredient, Errors errors){
        if(!errors.hasErrors()){
            ingredientDAO.save(ingredient);
            return "redirect:";
        }
        model.addAttribute(new Ingredient()); //key is "category"
        model.addAttribute("title", "Add Ingredient");

        return "ingredient/add"; //redirects you to ingredient/add

    }




}
