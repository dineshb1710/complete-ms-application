package com.dinesh.appz.restaurant.repo;

import com.dinesh.appz.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    // Custom methods goes here..
}
