package com.customerpc1.Services;

import com.customerpc1.Domain.Customer;
import com.customerpc1.Exception.CustomerExistsAlready;
import com.customerpc1.Exception.CustomerNotExists;
import com.customerpc1.Proxy.CustomerProxy;
import com.customerpc1.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    private CustomerRepository customerRepository;
    private CustomerProxy customerProxy;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerProxy customerProxy) {
        this.customerRepository = customerRepository;
        this.customerProxy = customerProxy;
    }

    @Override
    public Customer saveAllCustomerDetails(Customer customer) throws CustomerExistsAlready {
        if (customerRepository.findById(customer.getCustomerId()).isPresent()){
            throw new CustomerExistsAlready();
        }
        customerProxy.saveProxy(customer);
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchCustomerDetails() throws CustomerNotExists {
        if (customerRepository.findAll().isEmpty()){
            throw new CustomerNotExists();
        }
        return customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(int custId) throws CustomerNotExists{
        if (customerRepository.findById(custId).isEmpty()){
            throw new CustomerNotExists();
        }
        customerRepository.deleteById(custId);
        return true;
    }

    @Override
    public List<Customer> findAllCustomerFromProductName(String prodName) throws CustomerNotExists{
        if (customerRepository.findAllCustomerFromProductName(prodName).isEmpty()){
            throw new CustomerNotExists();
        }
        return customerRepository.findAllCustomerFromProductName(prodName);
    }
}
