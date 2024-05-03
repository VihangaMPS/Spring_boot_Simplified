package com.example.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("in Constructor" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim up Swim up Swim up";
    }
}
