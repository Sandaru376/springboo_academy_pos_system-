package com.springbootacademy.pos_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date orderDate;

    @Column(name = "total", nullable = false)
    private Double total;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderDetails> orderDetails = new HashSet<>();

    public Order(Customer customer, Date orderDate, Double total) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.total = total;
    }
}
