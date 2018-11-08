package com.longhoang.controllers;

import com.longhoang.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/home")
    public ModelAndView index() {
        return new ModelAndView("list", "blogs", blogService.findAll());
    }
}
