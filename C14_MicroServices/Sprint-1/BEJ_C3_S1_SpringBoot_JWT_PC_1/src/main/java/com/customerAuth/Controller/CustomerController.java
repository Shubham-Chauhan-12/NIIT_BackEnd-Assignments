package com.customerAuth.Controller;

import com.customerAuth.Services.CustomerServiceImpl;
import com.customerAuth.Domain.Customer;
import com.customerAuth.Exception.CustomerNotFoundException;
import com.customerAuth.Services.CustomerTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/user/v1")
public class CustomerController {

    private CustomerServiceImpl customerService;
    private CustomerTokenGenerator customerTokenGenerator;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService, CustomerTokenGenerator customerTokenGenerator) {
        this.customerService = customerService;
        this.customerTokenGenerator = customerTokenGenerator;
    }

    @PostMapping("/save-customer")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        customerService.saveAllCustomer(customer);
        return new ResponseEntity<>("User Registered SuccessFully", HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/fetch-AllCustomer")
    public ResponseEntity<?> fetchAllCustomer() throws CustomerNotFoundException {
        try {
            return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.FOUND);
        }
        catch (CustomerNotFoundException e ){
            throw new CustomerNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Internal Server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/customerLoginCheck")
    public ResponseEntity<?> loginCustomerAuth(@RequestBody Customer customer) throws CustomerNotFoundException {
        try {
            customerService.loginCustomerCheck(customer.getCustomerName(), customer.getPassword());
            Map<String,String> secretKey = new HashMap<>();
            secretKey = customerTokenGenerator.generateToken(customer);
            return new ResponseEntity<>(secretKey,HttpStatus.OK);
        }
        catch (CustomerNotFoundException e){
            throw new CustomerNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Internal Server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
