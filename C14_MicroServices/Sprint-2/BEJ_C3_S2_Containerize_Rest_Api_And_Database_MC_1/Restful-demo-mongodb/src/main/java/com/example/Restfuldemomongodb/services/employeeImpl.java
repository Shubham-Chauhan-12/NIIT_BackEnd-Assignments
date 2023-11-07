package com.example.Restfuldemomongodb.services;

import com.example.Restfuldemomongodb.domain.Customer;
import com.example.Restfuldemomongodb.exception.CustomerIdINotPresent;
import com.example.Restfuldemomongodb.exception.CustomerIdIsPresent;
import com.example.Restfuldemomongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class employeeImpl implements IemployeeSeervice{

    private CustomerRepository customerRepository;
    @Autowired
    public employeeImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }






    @Override
    public Customer saveEmp(Customer e) throws CustomerIdIsPresent {

        if(customerRepository.findById(e.getCustomerId()).isPresent()){
            throw new CustomerIdIsPresent();
        }
        return customerRepository.save(e);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Boolean delete(int name) throws CustomerIdINotPresent {

        if (customerRepository.findById(name).isEmpty()){
            throw new CustomerIdINotPresent();
        }
        customerRepository.deleteById(name);
        return true;
    }

    @Override
    public Optional<Customer> fetchById(int trackId) {
        return customerRepository.findById(trackId);
    }

    @Override
    public Customer updateTrack(Customer customer) {
        Customer customer1 = null;
        Optional<Customer> empId = customerRepository.findById(customer.getCustomerId());

        if(empId.isPresent()){
            customer1 = empId.get();
            customer1.setCustomerName(customer.getCustomerName());
            customer1.setCustomerPhoneNo(customer.getCustomerPhoneNo());
            customer1.setProduct(customer.getProduct());
            customerRepository.save(customer1);

        }
            else {
                    return  new Customer();
                 }

            return customer1;
    }


    @Override
    public List<Customer> getEmployeeByName(String name) {
        return customerRepository.findByCustomerName(name);
    }

    @Override
    public List<Customer> getEmployeeByEmail(String name) {
        return customerRepository.findByCustomerPhoneNo(name);
    }

    @Override
    public List<Customer> getEmployeeByDept(String dcode) {
        return customerRepository.findAllCustomerFromProductName(dcode);
    }
}
