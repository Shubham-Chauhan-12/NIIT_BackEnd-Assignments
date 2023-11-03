package com.sprint3demo.Controller;

import com.sprint3demo.Domain.Customer;
import com.sprint3demo.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/v1")
public class CustomerController {

    private CustomerServices customerServices;

    @Autowired
    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @PostMapping("/save-details")
    public ResponseEntity<?> saveDetails(@RequestBody Customer customerObj){
        return new ResponseEntity<>(customerServices.saveCustomerDetails(customerObj), HttpStatus.CREATED);
    }

    @GetMapping("/get-details")
    public ResponseEntity<?> fetchDetails(){
        return new ResponseEntity<>(customerServices.fetchCustomerDetails(),HttpStatus.FOUND);
    }

    @GetMapping("/get-detailsById/{custId}")
    public ResponseEntity<?> fetchDetailsById(@PathVariable int custId){
        return new ResponseEntity<>(customerServices.fetchCustomerDetailsById(custId),HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-mappingById/{custId}")
    public ResponseEntity<?> deleteById(@PathVariable int custId){
        customerServices.deleteCustomer(custId);
        return new ResponseEntity<>("Data- Deleted Successfully",HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-detailsByState/{stateName}")
    public ResponseEntity<?> findCustomerByState(@PathVariable String stateName){
        return new ResponseEntity<>(customerServices.findAllCustomerFromState(stateName),HttpStatus.FOUND);
    }

    @GetMapping("/get-detailsByName/{name}")
    public ResponseEntity<?> findCustomer(@PathVariable String name){
        return new ResponseEntity<>(customerServices.findByCustomerName(name),HttpStatus.FOUND);
    }

    @GetMapping("/get-DetailsByProduct/{prodName}")
    public ResponseEntity<?> findCustomersByProdName(@PathVariable String prodName){
        return new ResponseEntity<>(customerServices.findByCustomerFromProdName(prodName),HttpStatus.FOUND);
    }
}
