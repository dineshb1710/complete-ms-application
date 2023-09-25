package com.dinesh.appz.restaurant.service;

import com.dinesh.appz.restaurant.dto.RestaurantDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantService {
    ResponseEntity<List<RestaurantDto>> fetchAll();

    ResponseEntity<RestaurantDto> addRestaurant(RestaurantDto restaurantDto);

    void deleteRestaurantById(int id);

    ResponseEntity<?> updateRestaurant(RestaurantDto restaurantDto);

    ResponseEntity<RestaurantDto> fetch(int id);
}
