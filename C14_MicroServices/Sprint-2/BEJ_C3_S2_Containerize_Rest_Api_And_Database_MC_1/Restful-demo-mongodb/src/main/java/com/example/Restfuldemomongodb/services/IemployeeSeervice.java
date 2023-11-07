package com.example.Restfuldemomongodb.services;

import com.example.Restfuldemomongodb.domain.Customer;
import com.example.Restfuldemomongodb.exception.CustomerIdINotPresent;
import com.example.Restfuldemomongodb.exception.CustomerIdIsPresent;

import java.util.List;
import java.util.Optional;

public interface IemployeeSeervice {



    Customer saveEmp(Customer e) throws CustomerIdIsPresent;
    List<Customer> getAll();
    Boolean delete(int name) throws CustomerIdINotPresent;
    Optional<Customer> fetchById(int trackId);
    Customer updateTrack(Customer customer);
    List<Customer> getEmployeeByName(String name);
    List<Customer> getEmployeeByEmail(String name);
    List<Customer> getEmployeeByDept(String dcode);
}
