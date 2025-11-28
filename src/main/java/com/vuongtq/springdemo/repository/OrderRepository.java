package com.vuongtq.springdemo.repository;

import com.vuongtq.springdemo.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
