package com.dinesh.appz.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private int userId;
    private RestaurantDto restaurant;
    private List<FoodItemDto> foodItems;
}
