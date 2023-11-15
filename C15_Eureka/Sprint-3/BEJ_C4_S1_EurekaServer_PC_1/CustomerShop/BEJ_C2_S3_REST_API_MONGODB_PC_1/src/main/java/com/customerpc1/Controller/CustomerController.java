package com.customerpc1.Controller;

import com.customerpc1.Domain.Customer;
import com.customerpc1.Exception.CustomerExistsAlready;
import com.customerpc1.Exception.CustomerNotExists;
import com.customerpc1.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/v1")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save-details")
    public ResponseEntity<?> saveCustomers(@RequestBody Customer customerObj) throws CustomerExistsAlready {
        try {
            return new ResponseEntity<>(customerService.saveAllCustomerDetails(customerObj), HttpStatus.CREATED);
        }
        catch (CustomerExistsAlready e) {
            throw new CustomerExistsAlready();
        }

        catch (Exception e){
            return new ResponseEntity<>("Server Error!!!try after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/get-details")
    public ResponseEntity<?> fetchAllCustomers() throws CustomerNotExists {
        try {
            return new ResponseEntity<>(customerService.fetchCustomerDetails(), HttpStatus.FOUND);
        }
        catch (CustomerNotExists e) {
            throw new CustomerNotExists();
        }
        catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete-customer/{custId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int custId) throws CustomerNotExists {
        try {
            return new ResponseEntity<>(customerService.deleteCustomer(custId),HttpStatus.ACCEPTED);
        }
        catch (CustomerNotExists e){
            throw new CustomerNotExists();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error!!!try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get-byProduct/{prodName}")
    public ResponseEntity<?> fetchByProductName(@PathVariable String prodName) throws CustomerNotExists {
        try {
            return new ResponseEntity<>(customerService.findAllCustomerFromProductName(prodName),HttpStatus.FOUND);
        }
        catch (CustomerNotExists e){
            throw new CustomerNotExists();
        }
        catch (Exception e ){
            return new ResponseEntity<>("Server Error!!!try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
