package com.springbootacademy.pos_system.service;

import com.springbootacademy.pos_system.dto.CustomerDto;
import com.springbootacademy.pos_system.entity.Customer;

import java.util.List;

public interface CustomerService {

    String saveCustomer(CustomerDto customerDto);

    String updateCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomers();

    String deleteCustomer(Integer id);
}

