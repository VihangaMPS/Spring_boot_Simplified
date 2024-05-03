package com.example.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("in Constructor:" + getClass().getSimpleName());
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("in doMyStartupStuff:" + getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyShutdownStuff() {
        System.out.println("in doMyShutdownStuff:" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice for Tennis in 1hr";
    }
}
