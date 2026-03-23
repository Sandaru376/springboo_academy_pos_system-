package com.springbootacademy.pos_system.dto;

import com.springbootacademy.pos_system.dto.ResponseOrderDetailsDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrderDetailsDto {

    private String itemName;
    private double qty;
    private double amount;
}
