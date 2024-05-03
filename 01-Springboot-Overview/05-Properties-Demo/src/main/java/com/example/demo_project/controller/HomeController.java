package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Value;
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

    //Inject Properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose new endpoint for "teamInfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + " Team name: " + teamName;
    }
}
