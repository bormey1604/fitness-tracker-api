package com.techgirl.fitness_tracker_api.services;

import com.techgirl.fitness_tracker_api.models.Goal;
import com.techgirl.fitness_tracker_api.repositories.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;

    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Goal updateStatus(Long id){
        Optional<Goal> goal = goalRepository.findById(id);

        if(goal.isPresent()){
            Goal existingGoal = goal.get();
            existingGoal.setAchieved(true);
            return goalRepository.save(existingGoal);
        }

        throw  new RuntimeException("Goal not found");
    }
}
