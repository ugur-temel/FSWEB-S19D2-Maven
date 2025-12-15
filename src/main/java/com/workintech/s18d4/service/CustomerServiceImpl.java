package com.workintech.s18d4.service;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer find(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(long id, Customer customer) {
        if(customerRepository.existsById(id)){
            customer.setId(id);
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public Customer delete(long id) {
       Customer customer = customerRepository.findById(id).orElse(null);
        if(customer != null) {
            customerRepository.delete(customer);
            return customer;
        }
        return null;
    }
}
