package com.dinesh.appz.restaurant.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RestaurantDto {

    private int id;
    private String name;
    private String address;
    private String city;
    private String description;
}
