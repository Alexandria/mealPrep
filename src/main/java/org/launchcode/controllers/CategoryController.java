package org.launchcode.controllers;

import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.launchcode.models.data.CheeseDao;

@RequestMapping("category")
@Controller
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;


}
