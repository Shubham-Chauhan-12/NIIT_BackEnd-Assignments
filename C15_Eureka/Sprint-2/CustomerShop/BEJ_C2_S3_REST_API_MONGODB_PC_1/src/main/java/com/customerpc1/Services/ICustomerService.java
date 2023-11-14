package com.customerpc1.Services;

import com.customerpc1.Domain.Customer;
import com.customerpc1.Exception.CustomerExistsAlready;
import com.customerpc1.Exception.CustomerNotExists;

import java.util.List;

public interface ICustomerService {

    Customer saveAllCustomerDetails(Customer customer) throws CustomerExistsAlready;

    List<Customer> fetchCustomerDetails() throws CustomerNotExists;

    public boolean deleteCustomer(int custId) throws CustomerNotExists;

    List<Customer> findAllCustomerFromProductName(String prodName) throws CustomerNotExists;
}
