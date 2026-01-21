package com.springbootacademy.pos_system.dto.request;

import com.springbootacademy.pos_system.entity.Item;
import com.springbootacademy.pos_system.entity.Oder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetails {



    private String itemName;


    private double qty;


    private double amount;


    private int oders;


    private int items;
}
