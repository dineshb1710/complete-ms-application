package com.dinesh.appz.food.controller;

import com.dinesh.appz.food.dto.FoodCataloguePage;
import com.dinesh.appz.food.dto.FoodItemDto;
import com.dinesh.appz.food.entity.FoodItem;
import com.dinesh.appz.food.service.FoodCatalogueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/foodCatalogue")
@RequiredArgsConstructor
public class FoodCatalogueController {

    private final FoodCatalogueService foodCatalogueService;

    @PostMapping("/addItem")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItem foodItem) {
        log.info("MSG='Add Food Item', item={}", foodItem);
        return foodCatalogueService.addFoodItem(foodItem);
    }

    @GetMapping("/fetch/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> addFoodItem(@PathVariable int restaurantId) {
        log.info("MSG='Fetch Food Items', restaurantId={}", restaurantId);
        return foodCatalogueService.fetchFoodCatalogueByRestaurantId(restaurantId);
    }
}
