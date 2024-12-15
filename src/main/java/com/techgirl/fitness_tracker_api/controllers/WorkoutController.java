package com.techgirl.fitness_tracker_api.controllers;

import com.techgirl.fitness_tracker_api.models.Workout;
import com.techgirl.fitness_tracker_api.services.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workouts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WorkoutController {
    private final WorkoutService workoutService;

    @PostMapping()
    public ResponseEntity<?> postWorkout(@RequestBody Workout workout) {
        try{
            return new ResponseEntity<>(workoutService.postWorkout(workout), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllWorkout() {
        try{
            return new ResponseEntity<>(workoutService.getAllWorkouts(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
