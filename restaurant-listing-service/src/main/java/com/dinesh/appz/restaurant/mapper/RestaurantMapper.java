package com.dinesh.appz.restaurant.mapper;

import com.dinesh.appz.restaurant.dto.RestaurantDto;
import com.dinesh.appz.restaurant.entity.Restaurant;
import org.mapstruct.Mapper;

@Mapper
public interface RestaurantMapper {

    Restaurant dtoToEntity(RestaurantDto restaurantDto);

    RestaurantDto entityToDto(Restaurant restaurant);
}
