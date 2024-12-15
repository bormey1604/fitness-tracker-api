package com.techgirl.fitness_tracker_api.repositories;

import com.techgirl.fitness_tracker_api.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    @Query(value = "select count(*) from Goal where achieved = true", nativeQuery = true)
    Long countAchievedGoals();

    @Query(value = "select count(*) from Goal where achieved = false", nativeQuery = true)
    Long countNotAchievedGoals();
}
