package com.dinesh.appz.restaurant.service.impl;

import com.dinesh.appz.restaurant.dto.RestaurantDto;
import com.dinesh.appz.restaurant.entity.ResponseMessage;
import com.dinesh.appz.restaurant.entity.Restaurant;
import com.dinesh.appz.restaurant.mapper.RestaurantMapper;
import com.dinesh.appz.restaurant.repo.RestaurantRepository;
import com.dinesh.appz.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper = Mappers.getMapper(RestaurantMapper.class);

    @Override
    public ResponseEntity<List<RestaurantDto>> fetchAll() {
        log.info("Inside Restaurant Service, fetching all restaurants.");
        return ResponseEntity.ok(restaurantRepository.findAll()
                .stream()
                .map(restaurantMapper::entityToDto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<RestaurantDto> addRestaurant(Restaurant restaurant) {
        log.info("MSG='Adding restaurant to the database', restaurant={}", restaurant);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return new ResponseEntity<>(restaurantMapper.entityToDto(savedRestaurant), CREATED);
    }

    @Override
    public void deleteRestaurantById(int id) {
        log.info("MSG='Deleting restaurant by Id={}'", id);
        restaurantRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<?> updateRestaurant(Restaurant restaurant) {
        log.info("MSG='Updating restaurant to the database, restaurant={}'", restaurant);
        if (restaurant.getId() == 0) {
            return ResponseEntity.internalServerError()
                    .body(new ResponseMessage("Cannot update as the request doesn't consist of a valid id"));

        }
        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return new ResponseEntity<>(restaurantMapper.entityToDto(updatedRestaurant), ACCEPTED);
    }

    @Override
    public ResponseEntity<RestaurantDto> fetch(int id) {
        log.info("MSG='Fetching restaurant', id={}", id);
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isPresent()) {
            return ResponseEntity.ok(restaurantMapper.entityToDto(restaurant.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
