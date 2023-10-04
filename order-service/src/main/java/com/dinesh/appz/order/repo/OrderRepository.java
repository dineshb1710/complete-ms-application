package com.dinesh.appz.order.repo;

import com.dinesh.appz.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {
    // Custom methods goes here..
}
