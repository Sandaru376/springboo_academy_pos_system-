package com.springbootacademy.pos_system.service.impl;

import com.springbootacademy.pos_system.dto.CustomerDto;
import com.springbootacademy.pos_system.entity.Customer;
import com.springbootacademy.pos_system.repo.CustomerRepo;
import com.springbootacademy.pos_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDto customerDto) {

        Customer customer = new Customer(
                customerDto.getCustomerName(),
                customerDto.getCustomerAddress(),
                customerDto.getCustomerSalary(),
                customerDto.getContactNumber(),
                customerDto.getNic(),
                customerDto.isActive()
        );

        customerRepo.save(customer);
        return "Customer saved successfully";
    }

    @Override
    public String updateCustomer(CustomerDto customerDto) {

        if (customerRepo.existsById(customerDto.getCustomerId())) {

            Customer customer = customerRepo.findById(customerDto.getCustomerId()).get();

            customer.setCustomerName(customerDto.getCustomerName());
            customer.setCustomerAddress(customerDto.getCustomerAddress());
            customer.setCustomerSalary(customerDto.getCustomerSalary());
            customer.setContactNumber(customerDto.getContactNumber());
            customer.setNic(customerDto.getNic());
            customer.setActive(customerDto.isActive());

            customerRepo.save(customer);
            return "Customer updated successfully";

        } else {
            return "Customer not found";
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {

        List<Customer> customers = customerRepo.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer customer : customers) {

            CustomerDto dto = new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );

            customerDtoList.add(dto);
        }

        return customerDtoList;
    }

    @Override
    public String deleteCustomer(Integer id) {

        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
            return "Customer deleted successfully";
        } else {
            return "Customer not found";
        }
    }
}
