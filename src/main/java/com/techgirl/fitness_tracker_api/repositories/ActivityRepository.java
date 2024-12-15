package com.techgirl.fitness_tracker_api.repositories;

import com.techgirl.fitness_tracker_api.models.Activity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query(value = "select sum(steps) from Activity", nativeQuery = true)
    Integer getTotalSteps();

    @Query(value = "select sum(distance) from Activity", nativeQuery = true)
    Double getTotalDistance();

    @Query(value = "select sum(calories_burned) from Activity", nativeQuery = true)
    Integer getTotalActivityCalories();

    @Query(value = "select * from Activity order by date desc", nativeQuery = true)
    List<Activity> findLast7Activities(Pageable pageable);
}
