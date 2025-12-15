package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;

import java.util.List;

public interface AddressService {

    public List<Address> getAllAddresses();
    public Address getAddressById(long id);
    public Address addAddress(Address address);
    public Address updateAddress(long customerId, Address address);
    public Address deleteAddress(long id);
}
