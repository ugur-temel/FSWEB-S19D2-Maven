package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerService.findAll();
        return customers.stream().map(customer -> new CustomerResponse(customer.getId(),customer.getEmail(),customer.getSalary()))
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(@PathVariable long id) {
        Customer customer = customerService.find(id);
        return new CustomerResponse(customer.getId(),customer.getEmail(),customer.getSalary());
    }
    @PostMapping
    public CustomerResponse addCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        return new CustomerResponse(savedCustomer.getId(),savedCustomer.getEmail(),savedCustomer.getSalary());
    }
    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.update(id, customer);
        return new CustomerResponse(updatedCustomer.getId(), updatedCustomer.getEmail(), updatedCustomer.getSalary());
    }
    @DeleteMapping("/{id}")
    public CustomerResponse deleteCustomer(@PathVariable long id) {
        customerService.delete(id);
        return new CustomerResponse(0,"",0.0);
    }
}