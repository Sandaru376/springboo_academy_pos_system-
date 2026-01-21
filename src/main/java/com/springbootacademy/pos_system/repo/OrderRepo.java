package com.springbootacademy.pos_system.repo;

import com.springbootacademy.pos_system.entity.Oder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Oder, Integer> {
}
