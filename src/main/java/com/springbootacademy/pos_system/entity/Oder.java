package com.springbootacademy.pos_system.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "oder")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Oder {
    @Id
    @Column(name="oder_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oderId;

    @ManyToOne
    @JoinColumn(name="customer_id",nullable = false)
    private Customer customer;

    @Column(name="order_date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name="total",nullable = false)
    private Double total;

    @OneToMany(mappedBy = "oders")
    private Set<OrderDetails> orderDetails;

    public Oder(Customer customer, Date date, Double total) {
        this.customer = customer;
        this.date = date;
        this.total = total;
    }

}
