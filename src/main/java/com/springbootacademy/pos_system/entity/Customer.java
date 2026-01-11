package com.springbootacademy.pos_system.entity;

import javax.persistence.*;

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

    public Customer() {}

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
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }

    public double getCustomerSalary() { return customerSalary; }
    public void setCustomerSalary(double customerSalary) { this.customerSalary = customerSalary; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getNic() { return nic; }
    public void setNic(String nic) { this.nic = nic; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
