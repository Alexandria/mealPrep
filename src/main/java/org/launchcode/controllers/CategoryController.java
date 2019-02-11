package org.launchcode.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.launchcode.models.Category;
import org.launchcode.models.Cheese;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.launchcode.models.data.CheeseDao;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("category")
@Controller
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index (Model model){
        model.addAttribute("title", "Categories");
        model.addAttribute("categories", categoryDao.findAll());

        return "category/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new Category()); //key is "category"
        model.addAttribute("title", "Add Category");
        return "category/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Category category, Errors errors){
        if(!errors.hasErrors()){
            categoryDao.save(category);
            return "redirect:";
        }
        model.addAttribute(new Category()); //key is "category"
        model.addAttribute("title", "Add Category");
        return "category/add"; //redirects you to category/add

    }




}
