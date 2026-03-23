package com.springbootacademy.pos_system.repo;


import com.springbootacademy.pos_system.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
