package com.customerpc1.Repository;

import com.customerpc1.Domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {


    // Query for finding product = Samsung

    @Query("{'customerProduct.productName':{$in:[?0]}}")
    List<Customer> findAllCustomerFromProductName(String prodName);


}
