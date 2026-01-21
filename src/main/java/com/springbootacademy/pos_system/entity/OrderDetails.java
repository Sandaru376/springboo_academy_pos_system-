package com.springbootacademy.pos_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_details") // avoid "-" (hyphen) in table names
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oder_details_id")
    private int oderDetailsId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "qty", nullable = false)
    private double qty;

    @Column(name = "amount", nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "oder_id", nullable = false)
    private Oder oders;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item items;
}
