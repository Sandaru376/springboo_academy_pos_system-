package com.springbootacademy.pos_system.dto.request;

import com.springbootacademy.pos_system.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDto {

    private String itemName;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
}
