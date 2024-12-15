package com.techgirl.fitness_tracker_api.controllers;

import com.techgirl.fitness_tracker_api.models.Activity;
import com.techgirl.fitness_tracker_api.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping()
    public ResponseEntity<?> postActivity(@RequestBody Activity activity) {

        Activity createdActivity = activityService.postActivity(activity);
        if(createdActivity != null) {
            return new ResponseEntity<>(createdActivity, HttpStatus.OK);
        }

        return new ResponseEntity<>("Somethings went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping()
    public ResponseEntity<?> getActivities() {
        try{
            return new ResponseEntity<>(activityService.getActivities(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Somethings went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
