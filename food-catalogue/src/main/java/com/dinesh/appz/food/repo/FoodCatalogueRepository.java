package com.dinesh.appz.food.repo;

import com.dinesh.appz.food.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCatalogueRepository extends JpaRepository<FoodItem, Integer> {

    // Custom methods goes here..
    List<FoodItem> findByRestaurantId(int restaurantId);
}
