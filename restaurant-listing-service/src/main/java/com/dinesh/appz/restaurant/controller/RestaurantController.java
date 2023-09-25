package com.dinesh.appz.restaurant.controller;

import com.dinesh.appz.restaurant.dto.RestaurantDto;
import com.dinesh.appz.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/fetch/{id}")
    public ResponseEntity<RestaurantDto> fetchRestaurantById(@PathVariable int id) {
        log.info("MSG='Fetch restaurant', id={}", id);
        return restaurantService.fetch(id);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<RestaurantDto>> fetchAllRestaurants() {
        log.info("Fetching all restaurants..");
        return restaurantService.fetchAll();
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        log.info("MSG='Adding restaurant', restaurantDto={}", restaurantDto);
        return restaurantService.addRestaurant(restaurantDto);
    }

    @PutMapping("/updateRestaurant")
    public ResponseEntity<?> updateRestaurant(@RequestBody RestaurantDto restaurantDto) {
        log.info("MSG='Updating restaurant', restaurantDto={}", restaurantDto);
        return restaurantService.updateRestaurant(restaurantDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable int id) {
        log.info("MSG='Delete restaurant', id={}", id);
        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.ok().build();
    }

}
