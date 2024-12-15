package com.techgirl.fitness_tracker_api.services;

import com.techgirl.fitness_tracker_api.models.Activity;
import com.techgirl.fitness_tracker_api.repositories.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService{
    private final ActivityRepository activityRepository;

    public Activity postActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

}