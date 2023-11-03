package com.sprint3demo.Repository;

import com.sprint3demo.Domain.Customer;
import com.sprint3demo.Domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {

    @Query("{'customerAdd.state':{$in:[?0]}}")
    List<Customer> findAllCustomerFromState(String stateName);

    List<Customer> findByCustomerName(String customerName);

    @Query("{'productList.prodName':{$in:[?0]}}")
    List<Customer> findByCustomerFromProdName(String prodName);




}
