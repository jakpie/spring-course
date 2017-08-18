package com.sda.springcourse.controller;

import com.sda.springcourse.model.News;
import com.sda.springcourse.repository.NewsRepository;
import com.sda.springcourse.repository.UserRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userRepository.getAll());
        return modelAndView;
    }

    @RequestMapping(params = {"lastName"})
    public ModelAndView usersByLastName(@RequestParam String lastName) {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userRepository.getAllByLastName(lastName));
        return modelAndView;
    }

    @RequestMapping(path = "/{id}")
    public ModelAndView specifiedUser(@PathVariable("id") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", userRepository.getById(userId));
        modelAndView.addObject("allNews",newsRepository.getByUserId(userId));
        return modelAndView;
    }

    @PostMapping(path = "/{userId}/news")
    public ModelAndView addUser(@ModelAttribute News news, @PathVariable("userId") Integer userId) {
        boolean creationStatus = newsRepository.add(news);
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", userRepository.getById(userId));
        modelAndView.addObject("allNews",newsRepository.getByUserId(userId));
        modelAndView.addObject("creationStatus", creationStatus);
        modelAndView.addObject("creationSuccessMessage", "Successfully added news");
        modelAndView.addObject("creationErrorMessage", "Couldn't create news"); //dokonczyc
        return modelAndView;
    }
}
