package com.dinesh.appz.order.entity;

import com.dinesh.appz.order.dto.FoodItemDto;
import com.dinesh.appz.order.dto.RestaurantDto;
import com.dinesh.appz.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int orderId;
    private List<FoodItemDto> foodItems;
    private RestaurantDto restaurant;
    private UserDto userInfo;
}
