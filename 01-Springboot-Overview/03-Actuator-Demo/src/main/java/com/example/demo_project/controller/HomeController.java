package com.example.demo_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = {"", "/", "home"})
    public String displayHome() {
        return "Hello World";
    }

    @GetMapping(value = {"/workout"})
    public String displayWorkout() {
        return "Workout Page";
    }
}
