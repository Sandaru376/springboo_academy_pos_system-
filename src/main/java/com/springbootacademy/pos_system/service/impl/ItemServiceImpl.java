package com.springbootacademy.pos_system.service.impl;

import com.springbootacademy.pos_system.dto.request.ItemGetResponseDto;
import com.springbootacademy.pos_system.dto.request.ItemSaveRequestDto;
import com.springbootacademy.pos_system.entity.Item;
import com.springbootacademy.pos_system.repo.ItemRepo;
import com.springbootacademy.pos_system.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDto dto) {

        Item item = modelMapper.map(dto, Item.class);
        item.setActive(true);

        itemRepo.save(item);

        return item.getItemId() + " saved successfully";
    }

    @Override
    public List<ItemGetResponseDto> getItemByNameAndStatus(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActive(itemName, true);

        if (items.isEmpty()) {
            throw new RuntimeException("Item not found or inactive");
        }

        List<ItemGetResponseDto> itemGetResponseDtos =
                modelMapper.map(items, new TypeToken<List<ItemGetResponseDto>>() {}.getType());

        return itemGetResponseDtos;
    }

}
