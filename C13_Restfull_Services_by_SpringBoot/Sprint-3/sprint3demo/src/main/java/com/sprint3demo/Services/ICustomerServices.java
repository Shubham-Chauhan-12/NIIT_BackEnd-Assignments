package com.sprint3demo.Services;

import com.sprint3demo.Domain.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerServices {

    List<Customer> findAllCustomerFromState(String stateName);

    List<Customer> findByCustomerName(String customerName);

    List<Customer> findByCustomerFromProdName(String prodName);

    Customer saveCustomerDetails(Customer customer);

    Optional<Customer> fetchCustomerDetailsById(int custId);

    List<Customer> fetchCustomerDetails();

    public boolean deleteCustomer(int custId);

}
