package com.dinesh.appz.order.mapper;

import com.dinesh.appz.order.dto.OrderDto;
import com.dinesh.appz.order.entity.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    Order dtoToEntity(OrderDto orderDto);

    OrderDto entityToDto(Order order);
}
