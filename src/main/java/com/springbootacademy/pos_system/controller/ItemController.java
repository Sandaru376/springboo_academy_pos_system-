package com.springbootacademy.pos_system.controller;

import com.springbootacademy.pos_system.dto.CustomerDto;
import com.springbootacademy.pos_system.dto.request.ItemGetResponseDto;
import com.springbootacademy.pos_system.dto.request.ItemSaveRequestDto;
import com.springbootacademy.pos_system.entity.Item;
import com.springbootacademy.pos_system.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody ItemSaveRequestDto dto) {
        return itemService.saveItem(dto);
    }



    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemGetResponseDto> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDto> itemDto=itemService.getItemByNameAndStatus(itemName);
        return itemDto;
    }

    @GetMapping("/get-all-items")
    public List<ItemGetResponseDto> getAllItems() {
        return itemService.getAllItems(); // ✅ correct
    }

    @PutMapping("/update-item")
    public String updateItem(@RequestBody ItemSaveRequestDto itemSaveRequestDto) {
        return itemService.updateItem(itemSaveRequestDto);
    }

    @DeleteMapping("/item-delete/{id}")
    public String deleteItem(@PathVariable Integer id) {
        return itemService.deleteItem(id);
    }

}
