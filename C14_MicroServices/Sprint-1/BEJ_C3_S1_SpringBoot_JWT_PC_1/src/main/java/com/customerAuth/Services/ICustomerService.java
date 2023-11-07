package com.customerAuth.Services;

import com.customerAuth.Domain.Customer;
import com.customerAuth.Exception.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {

    Customer saveAllCustomer(Customer customer);
    List<Customer> getAllCustomer() throws CustomerNotFoundException;
    Customer loginCustomerCheck(String userName, String password) throws CustomerNotFoundException;
}
