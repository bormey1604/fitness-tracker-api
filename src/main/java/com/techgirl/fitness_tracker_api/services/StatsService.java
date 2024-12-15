package com.techgirl.fitness_tracker_api.services;

import com.techgirl.fitness_tracker_api.models.Activity;
import com.techgirl.fitness_tracker_api.models.GraphDto;
import com.techgirl.fitness_tracker_api.models.StatsDto;
import com.techgirl.fitness_tracker_api.models.Workout;
import com.techgirl.fitness_tracker_api.repositories.ActivityRepository;
import com.techgirl.fitness_tracker_api.repositories.GoalRepository;
import com.techgirl.fitness_tracker_api.repositories.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsService {
    private final GoalRepository goalRepository;
    private final ActivityRepository activityRepository;
    private final WorkoutRepository workoutRepository;

    public StatsDto getStats(){
        Long achivedGoals = goalRepository.countAchievedGoals();
        Long notAchivedGoals = goalRepository.countNotAchievedGoals();

        Integer totalSteps = activityRepository.getTotalSteps();
        Double totalDistance = activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned = activityRepository.getTotalActivityCalories();

        Integer totalWorkoutDuration = workoutRepository.getTotalDurations();
        Integer totalWorkoutCaloriesBurned = workoutRepository.getTotalCaloriesBurned();

        int totalCaloriesBurned = (totalActivityCaloriesBurned != null ? totalActivityCaloriesBurned : 0) +
                (totalWorkoutCaloriesBurned != null ? totalWorkoutCaloriesBurned : 0);

        StatsDto dto = new StatsDto();
        dto.setAchievedGoals(achivedGoals != null ? achivedGoals : 0);
        dto.setNotAchievedGoals(notAchivedGoals != null ? notAchivedGoals : 0);

        dto.setSteps(totalSteps != null ? totalSteps : 0);
        dto.setDistance(totalDistance != null ? totalDistance : 0);
        dto.setTotalCaloriesBurned(totalCaloriesBurned);
        dto.setDuration(totalWorkoutDuration != null ? totalWorkoutDuration : 0);

        return dto;
    }

    public GraphDto getGraphStats(){
        Pageable pageable = PageRequest.of(0, 7);
        List<Workout> workouts = workoutRepository.findLast7Workouts(pageable);
        List<Activity> activities = activityRepository.findLast7Activities(pageable);

        GraphDto graphDto = new GraphDto();
        graphDto.setWorkouts(workouts);
        graphDto.setActivities(activities);

        return graphDto;
    }

}
