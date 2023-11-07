package com.customerAuth.Repository;

import com.customerAuth.Domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByCustomerNameAndPassword(String customerName, String password);
}
