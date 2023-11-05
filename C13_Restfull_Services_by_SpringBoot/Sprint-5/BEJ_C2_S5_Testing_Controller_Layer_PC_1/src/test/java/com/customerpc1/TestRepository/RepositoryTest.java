package com.customerpc1.TestRepository;

import com.customerpc1.Domain.Customer;
import com.customerpc1.Domain.Product;
import com.customerpc1.Repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class RepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;
    private Product product;


    @BeforeEach
    public void setUp(){
        product = new Product(81,"Acer","Gaming Laptop");
        customer = new Customer(106,"Vaibhav",1223567889,product);
    }

    @AfterEach
    public void tearDown(){
        product = null;
        customer = null;
    }



    @Test
    public void saveCustomerCheck(){
     customerRepository.save(customer);
     Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
     assertNotNull(customer1);
     assertEquals(customer.getCustomerId(),customer1.getCustomerId());
    }

    @Test
    public void customerCountEqualsToTotalCustomers(){
        assertEquals(5,customerRepository.count());
    }

    @Test
    public void deleteTheCustomerById(){
        customerRepository.deleteById(106);
        assertEquals(4,customerRepository.count());
        assertEquals(Optional.empty(),customerRepository.findById(106));
    }



    @Test
    public void checkProductNamWithCustomerDb(){

        List<Customer> customerList = customerRepository.findAllCustomerFromProductName("Samsung");
        assertEquals(2,customerList.size());

    }
}
