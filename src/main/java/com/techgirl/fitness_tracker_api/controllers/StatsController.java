package com.techgirl.fitness_tracker_api.controllers;

import com.techgirl.fitness_tracker_api.models.GraphDto;
import com.techgirl.fitness_tracker_api.services.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {
    private final StatsService statsService;

    @GetMapping
    public ResponseEntity<?> getStats() {
        return new ResponseEntity<>(statsService.getStats(), HttpStatus.OK);
    }

    @GetMapping("/graphs")
    public ResponseEntity<?> getGraphStats() {

        GraphDto graphDto = statsService.getGraphStats();
        if(graphDto != null) {
            return new ResponseEntity<>(graphDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
