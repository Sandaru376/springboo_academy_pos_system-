package com.springbootacademy.pos_system.service;

import com.springbootacademy.pos_system.dto.request.ItemGetResponseDto;
import com.springbootacademy.pos_system.dto.request.ItemSaveRequestDto;
import com.springbootacademy.pos_system.entity.Item;

import java.util.List;

public interface ItemService {
    List<ItemGetResponseDto> getAllItems();

    String saveItem(ItemSaveRequestDto itemSaveRequestDto);

    List<ItemGetResponseDto> getItemByNameAndStatus(String itemName);


    String updateItem(ItemSaveRequestDto itemSaveRequestDto);

    String deleteItem(Integer id);
}
