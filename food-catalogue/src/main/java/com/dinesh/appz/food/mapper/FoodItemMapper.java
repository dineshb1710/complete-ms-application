package com.dinesh.appz.food.mapper;

import com.dinesh.appz.food.dto.FoodItemDto;
import com.dinesh.appz.food.entity.FoodItem;
import org.mapstruct.Mapper;

@Mapper
public interface FoodItemMapper {

    FoodItemDto fromEntityToDto(FoodItem foodItem);

    FoodItem fromDtoToEntity(FoodItemDto foodItemDto);
}
