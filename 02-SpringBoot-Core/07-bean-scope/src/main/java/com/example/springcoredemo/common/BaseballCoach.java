package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach() {
        System.out.println("in Constructor:" + getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "Practice for Baseball in 30min";
    }
}
