package com.techgirl.fitness_tracker_api.models;

import lombok.Data;

import java.util.List;

@Data
public class GraphDto {
    private List<Workout> workouts;
    private List<Activity> activities;
}
