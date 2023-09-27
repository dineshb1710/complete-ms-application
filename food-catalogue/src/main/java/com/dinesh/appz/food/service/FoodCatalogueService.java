package com.dinesh.appz.food.service;

import com.dinesh.appz.food.dto.FoodCataloguePage;
import com.dinesh.appz.food.dto.FoodItemDto;
import com.dinesh.appz.food.entity.FoodItem;
import org.springframework.http.ResponseEntity;

public interface FoodCatalogueService {

    ResponseEntity<FoodItemDto> addFoodItem(FoodItem foodItem);

    ResponseEntity<FoodCataloguePage> fetchFoodCatalogueByRestaurantId(int id);
}
