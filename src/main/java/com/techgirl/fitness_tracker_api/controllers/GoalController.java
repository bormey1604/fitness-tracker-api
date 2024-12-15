package com.techgirl.fitness_tracker_api.controllers;

import com.techgirl.fitness_tracker_api.models.Goal;
import com.techgirl.fitness_tracker_api.services.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/goals")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GoalController {
    private final GoalService goalService;

    @PostMapping()
    public ResponseEntity<?> createGoal(@RequestBody Goal goal) {

        Goal createdGoal = goalService.createGoal(goal);
        if(createdGoal != null) {
            return new ResponseEntity<>(createdGoal, HttpStatus.OK);
        }

        return new ResponseEntity<>("Somethings went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping()
    public ResponseEntity<?> getGoals() {
        try{
            return new ResponseEntity<>(goalService.getAllGoals(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Somethings went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(goalService.updateStatus(id), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}
