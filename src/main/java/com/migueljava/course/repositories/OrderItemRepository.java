package com.migueljava.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.migueljava.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
