package com.springbootacademy.pos_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state")
    private boolean active;

    public Customer() {
    }

    public Customer(String customerName, String customerAddress, double customerSalary,
                    String contactNumber, String nic, boolean active) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.active = active;
    }

    // Getters & Setters
}
