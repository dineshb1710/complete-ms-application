package com.dinesh.appz.order.service;

import com.dinesh.appz.order.dto.OrderDto;
import com.dinesh.appz.order.dto.OrderRequestDto;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<OrderDto> createOrder(OrderRequestDto orderRequestDto);
}
