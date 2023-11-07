package com.customerAuth.Services;

import com.customerAuth.Domain.Customer;
import com.customerAuth.Exception.CustomerNotFoundException;
import com.customerAuth.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveAllCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() throws CustomerNotFoundException {
        if (customerRepository.findAll().isEmpty()){
            throw new CustomerNotFoundException();
        }
        return customerRepository.findAll();
    }

    @Override
    public Customer loginCustomerCheck(String customerName, String password) throws CustomerNotFoundException {
        Customer authorisedCustomer = customerRepository.findByCustomerNameAndPassword(customerName,password);
        if (authorisedCustomer==null){
            throw new CustomerNotFoundException();
        }
        return customerRepository.findByCustomerNameAndPassword(customerName,password);
    }
}
