package com.springbootacademy.pos_system.controller;
import com.springbootacademy.pos_system.util.StandardResponse;



import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.springbootacademy.pos_system.dto.CustomerDto;
import com.springbootacademy.pos_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.saveCustomer(customerDto);
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerDto);
    }

    @GetMapping("/get-all")
    public ResponseEntity<StandardResponse> getAllCustomers() {

        List<CustomerDto> customers = customerService.getAllCustomers();

        StandardResponse response = new StandardResponse(
                200,
                "SUCCESS",
                customers
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        return customerService.deleteCustomer(id);
    }
}
