package com.springbootacademy.pos_system.service;

import com.springbootacademy.pos_system.dto.request.ItemGetResponseDto;
import com.springbootacademy.pos_system.dto.request.ItemSaveRequestDto;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDto itemSaveRequestDto);

    List<ItemGetResponseDto> getItemByNameAndStatus(String itemName);
}
