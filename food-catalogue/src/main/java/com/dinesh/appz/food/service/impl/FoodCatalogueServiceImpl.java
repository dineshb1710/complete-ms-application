package com.dinesh.appz.food.service.impl;

import com.dinesh.appz.food.dto.FoodCataloguePage;
import com.dinesh.appz.food.dto.FoodItemDto;
import com.dinesh.appz.food.dto.Restaurant;
import com.dinesh.appz.food.entity.FoodItem;
import com.dinesh.appz.food.mapper.FoodItemMapper;
import com.dinesh.appz.food.repo.FoodCatalogueRepository;
import com.dinesh.appz.food.service.FoodCatalogueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodCatalogueServiceImpl implements FoodCatalogueService {

    private final FoodCatalogueRepository foodCatalogueRepository;
    private final RestTemplate restTemplate;

    private final FoodItemMapper foodItemMapper = Mappers.getMapper(FoodItemMapper.class);

    @Override
    public ResponseEntity<FoodItemDto> addFoodItem(FoodItem foodItem) {
        log.info("MSG='Inside FoodCatalogueServiceImpl, addFoodItem, foodItem={}'", foodItem);
        FoodItem savedFoodItem = foodCatalogueRepository.save(foodItem);
        return new ResponseEntity<>(foodItemMapper.fromEntityToDto(savedFoodItem), HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<FoodCataloguePage> fetchFoodCatalogueByRestaurantId(int restaurantId) {
        log.info("MSG='Inside FoodCatalogueServiceImpl, fetchFoodCatalogue, restaurantId={}'", restaurantId);

        // Fetch all foodItems, that belong to that corresponding restaurant id..
        List<FoodItem> foodItems = foodCatalogueRepository.findByRestaurantId(restaurantId);

        // Fetch Restaurant details..
        Restaurant restaurant = restTemplate.getForObject(
                "http://RESTAURANT-SERVICE:8081/api/v1/restaurant/fetch/" + restaurantId,
                Restaurant.class);

        return new ResponseEntity<>(new FoodCataloguePage(foodItems, restaurant), HttpStatus.OK);
    }
}
