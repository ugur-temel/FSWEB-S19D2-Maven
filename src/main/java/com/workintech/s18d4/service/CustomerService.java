package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();
    public Customer find(long id);
    public Customer save(Customer customer);
    public Customer update(long id,Customer customer);
    public Customer delete(long id);
}
