package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.dto.AddressResponse;
import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<AddressResponse> getAllAddresses(){
        List<Address> addresses = addressService.getAllAddresses();
        return addresses.stream().map(address -> new AddressResponse("Addreess fetched", address))
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public AddressResponse getAddressById(@PathVariable long id){
        Address address = addressService.getAddressById(id);
        return new AddressResponse("Address fetched", address);
    }
    @PostMapping
    public AddressResponse addAddress(@RequestBody Address address){
        Address savedAddress = addressService.addAddress(address);
        return new AddressResponse("Address added", savedAddress);
    }
    @PutMapping("/{id}")
    public AddressResponse updateAddress(@PathVariable long id, @RequestBody Address address){
        Address updatedAddress = addressService.updateAddress(id, address);
        return  new AddressResponse("Address updated", updatedAddress);
    }

    @DeleteMapping("/{id}")
    public AddressResponse deleteAddress(@PathVariable long id){
        addressService.deleteAddress(id);
        return new AddressResponse("Address deleted", null);
    }
}
