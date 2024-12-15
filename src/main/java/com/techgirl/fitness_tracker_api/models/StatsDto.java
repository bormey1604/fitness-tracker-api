package com.techgirl.fitness_tracker_api.models;

import lombok.Data;

@Data
public class StatsDto {
    private Long achievedGoals;
    private Long notAchievedGoals;
    private int steps;
    private double distance;
    private int totalCaloriesBurned;
    private int duration;
}
