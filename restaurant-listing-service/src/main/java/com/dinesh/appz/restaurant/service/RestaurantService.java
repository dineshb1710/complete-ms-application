package com.dinesh.appz.restaurant.service;

import com.dinesh.appz.restaurant.dto.RestaurantDto;
import com.dinesh.appz.restaurant.entity.Restaurant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantService {
    ResponseEntity<List<RestaurantDto>> fetchAll();

    ResponseEntity<RestaurantDto> addRestaurant(Restaurant restaurant);

    void deleteRestaurantById(int id);

    ResponseEntity<?> updateRestaurant(Restaurant restaurant);

    ResponseEntity<RestaurantDto> fetch(int id);
}
