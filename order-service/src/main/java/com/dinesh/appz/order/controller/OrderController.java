package com.dinesh.appz.order.controller;

import com.dinesh.appz.order.dto.OrderDto;
import com.dinesh.appz.order.dto.OrderRequestDto;
import com.dinesh.appz.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderDto> create(@RequestBody OrderRequestDto orderRequestDto) {
        log.info("MSG='Inside OrderController, createOrderRequest={}'", orderRequestDto);
        return orderService.createOrder(orderRequestDto);
    }
}
