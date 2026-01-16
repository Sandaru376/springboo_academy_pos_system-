package com.springbootacademy.pos_system.repo;

import com.springbootacademy.pos_system.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
    List<Item> findAllByItemNameEqualsAndActive(String itemName, boolean active);

}
