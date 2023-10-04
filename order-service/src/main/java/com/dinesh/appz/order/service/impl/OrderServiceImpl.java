package com.dinesh.appz.order.service.impl;

import com.dinesh.appz.order.dto.OrderDto;
import com.dinesh.appz.order.dto.OrderRequestDto;
import com.dinesh.appz.order.dto.UserDto;
import com.dinesh.appz.order.entity.Order;
import com.dinesh.appz.order.mapper.OrderMapper;
import com.dinesh.appz.order.repo.OrderRepository;
import com.dinesh.appz.order.service.OrderService;
import com.dinesh.appz.order.utils.OrderServiceUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderServiceUtils orderServiceUtils;
    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);


    @Override
    public ResponseEntity<OrderDto> createOrder(OrderRequestDto orderRequestDto) {
        int orderId = orderServiceUtils.getNextOrderId();
        UserDto userInfo = orderServiceUtils.fetchUserInformationById(orderRequestDto.getUserId());
        Order order = new Order(orderId, orderRequestDto.getFoodItems(), orderRequestDto.getRestaurant(), userInfo);
        Order savedOrder = orderRepository.save(order);
        return new ResponseEntity(orderMapper.entityToDto(savedOrder), HttpStatus.CREATED);
    }

}
