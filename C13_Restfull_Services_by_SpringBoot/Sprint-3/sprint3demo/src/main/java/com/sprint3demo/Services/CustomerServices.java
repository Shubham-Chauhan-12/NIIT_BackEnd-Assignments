package com.sprint3demo.Services;

import com.sprint3demo.Domain.Customer;
import com.sprint3demo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices implements ICustomerServices {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomerFromState(String stateName) {
        return customerRepository.findAllCustomerFromState(stateName);
    }

    @Override
    public List<Customer> findByCustomerName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }

    @Override
    public List<Customer> findByCustomerFromProdName(String prodName) {
        return customerRepository.findByCustomerFromProdName(prodName);
    }

    @Override
    public Customer saveCustomerDetails(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> fetchCustomerDetailsById(int custId) {
        return customerRepository.findById(custId);
    }

    @Override
    public List<Customer> fetchCustomerDetails() {
        return customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(int custId) {
        customerRepository.deleteById(custId);
        return true;
    }
}
