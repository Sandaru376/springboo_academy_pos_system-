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

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ItemGetResponseDto> getAllItems() {
        List<Item> items=itemRepo.findAll();
        List<ItemGetResponseDto> DtoList=new ArrayList<>();

        for(Item item:items){
            ItemGetResponseDto itemGetResponseDto=modelMapper.map(item, ItemGetResponseDto.class);
            DtoList.add(itemGetResponseDto);
        }
        return DtoList;
    }

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

    @Override
    public String updateItem(ItemSaveRequestDto itemSaveRequestDto) {

        if(itemRepo.existsById(itemSaveRequestDto.getItemId())) { // ✅ use correct variable
            Item item = itemRepo.findById(itemSaveRequestDto.getItemId()).get(); // ✅ get entity from Optional

            // Update fields
            item.setItemName(itemSaveRequestDto.getItemName());
            item.setBalanceQty(itemSaveRequestDto.getBalanceQty());
            item.setSupplierPrice(itemSaveRequestDto.getSupplierPrice());
            item.setSellingPrice(itemSaveRequestDto.getSellingPrice());
            item.setMeasuringUnitType(itemSaveRequestDto.getMeasuringUnitType());

            itemRepo.save(item); // Save updated item
            return "Item updated successfully";
        } else {
            return "Item not found"; // ✅ change text, not customer
        }
    }

    @Override
    public String deleteItem(Integer id) {
        if (itemRepo.existsById(id)) {
            itemRepo.deleteById(id);
            return "Customer deleted successfully";
        } else {
            return "Customer not found";
        }
    }


}
