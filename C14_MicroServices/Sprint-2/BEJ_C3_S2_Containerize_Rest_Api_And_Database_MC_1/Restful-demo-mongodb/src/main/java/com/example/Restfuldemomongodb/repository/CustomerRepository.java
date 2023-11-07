package com.example.Restfuldemomongodb.repository;

import com.example.Restfuldemomongodb.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {


    List<Customer> findByCustomerName(String ename);

    List<Customer> findByCustomerPhoneNo(String ename);


    @Query("{'product.productName':{$in:[?0]}}")
    List<Customer> findAllCustomerFromProductName(String productName);


}
