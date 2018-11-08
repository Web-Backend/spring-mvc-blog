package com.longhoang.controllers;

import com.longhoang.models.Blog;
import com.longhoang.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/home")
    public ModelAndView index() {
        return new ModelAndView("list", "blogs", blogService.findAll());
    }

    @GetMapping("/blog/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/blog/create")
    public ModelAndView createPost(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);

        ModelAndView modelAndView = new ModelAndView("create", "blog", blog);
        modelAndView.addObject("message", "Created successfully");
        return modelAndView;
    }

    @GetMapping("/blog/view/{id}")
    public ModelAndView viewDetail(@PathVariable int id) {
        return new ModelAndView("view", "blog", blogService.findById(id));
    }

    @GetMapping("/blog/edit/{id}")
    public ModelAndView viewUpdateForm(@PathVariable int id) {
        return new ModelAndView("update", "blog", blogService.findById(id));
    }

    @PostMapping("/blog/update")
    public ModelAndView update(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("update", "blog", blog);
        modelAndView.addObject("message", "Updated successfully");
        return modelAndView;
    }
}
