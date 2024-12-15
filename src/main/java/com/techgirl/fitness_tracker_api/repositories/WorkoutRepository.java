package com.techgirl.fitness_tracker_api.repositories;

import com.techgirl.fitness_tracker_api.models.Activity;
import com.techgirl.fitness_tracker_api.models.Workout;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    @Query(value = "select sum(duration) from Workout", nativeQuery = true)
    Integer getTotalDurations();

    @Query(value = "select sum(calories_burned) from Workout", nativeQuery = true)
    Integer getTotalCaloriesBurned();

    @Query(value = "select * from Workout order by date desc", nativeQuery = true)
    List<Workout> findLast7Workouts(Pageable pageable);

}
