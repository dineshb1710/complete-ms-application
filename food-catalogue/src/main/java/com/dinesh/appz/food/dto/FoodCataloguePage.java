package com.dinesh.appz.food.dto;

import com.dinesh.appz.food.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {

    private List<FoodItem> foodItems;
    private Restaurant restaurant;

}
