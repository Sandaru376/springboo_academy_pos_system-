package com.springbootacademy.pos_system.entity;

import com.springbootacademy.pos_system.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @Column(nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    private MeasuringUnitType measuringUnitType;

    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean active;
}
