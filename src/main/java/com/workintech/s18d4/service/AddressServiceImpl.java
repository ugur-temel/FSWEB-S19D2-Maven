package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElse(null);
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(long id, Address address) {
        if(addressRepository.existsById(id)){
            address.setId(id);
            return addressRepository.save(address);
        } else {
            return null;
        }
    }

    @Override
    public Address deleteAddress(long id) {
        Address address = addressRepository.findById(id).orElse(null);
        if(address != null){
            addressRepository.delete(address);
            return address;
        }
        return null;
    }
}
