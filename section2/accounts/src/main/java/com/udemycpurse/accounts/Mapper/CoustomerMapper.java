package com.udemycpurse.accounts.Mapper;

import com.udemycpurse.accounts.DTO.CustomerDTO;
import com.udemycpurse.accounts.Entity.Customer;

public class CoustomerMapper {

    public static CustomerDTO mapToCustomerDto(Customer customer, CustomerDTO customerDto) {
        customerDto.setCoustomerId(customer.getCoustomerId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDTO customerDto, Customer customer) {
        customer.setCoustomerId(customerDto.getCoustomerId());
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
