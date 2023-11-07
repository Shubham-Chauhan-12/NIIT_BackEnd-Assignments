package com.example.Restfuldemomongodb.controller;

import com.example.Restfuldemomongodb.domain.Customer;
import com.example.Restfuldemomongodb.exception.CustomerIdINotPresent;
import com.example.Restfuldemomongodb.exception.CustomerIdIsPresent;
import com.example.Restfuldemomongodb.services.IemployeeSeervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class employeeController {


    private IemployeeSeervice iemployeeSeervice;
    @Autowired
    public employeeController(IemployeeSeervice iemployeeSeervice) {
        this.iemployeeSeervice = iemployeeSeervice;
    }

    @PostMapping("/trackpost")
    public ResponseEntity<?> saveEmployee(@RequestBody Customer customer) throws CustomerIdIsPresent {

        try{
            return new ResponseEntity<>(iemployeeSeervice.saveEmp(customer), HttpStatus.CREATED);
        }
        catch (CustomerIdIsPresent c){
          throw  new CustomerIdIsPresent();
        }
        catch (Exception e){

            return new ResponseEntity<>("server error please try again",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getpost")
    public ResponseEntity<?> getEmployee(){
        return new ResponseEntity<>(iemployeeSeervice.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getpost/{empId}")
    public ResponseEntity<?> getEmployeeOnce(@PathVariable int empId){
        return new ResponseEntity<>(iemployeeSeervice.fetchById(empId), HttpStatus.OK);
    }

    @DeleteMapping("/deletepost/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id)throws CustomerIdINotPresent {
        try{
            return new ResponseEntity<>(iemployeeSeervice.delete(id), HttpStatus.OK);
        }
        catch(CustomerIdINotPresent c){
            throw new CustomerIdINotPresent();
        }
        catch (Exception e){
            return new ResponseEntity<>("server error please try again",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/trackpost")
    public ResponseEntity<?> updateTrack(@RequestBody Customer customer){
        return new ResponseEntity<>(iemployeeSeervice.updateTrack(customer), HttpStatus.OK);
    }


    @GetMapping("/getbyname/{empId}")
    public ResponseEntity<?> getEmployeeName(@PathVariable String empId){
        return new ResponseEntity<>(iemployeeSeervice.getEmployeeByName(empId), HttpStatus.OK);
    }

    @GetMapping("/getbyemail/{empId}")
    public ResponseEntity<?> getEmployeeEmail(@PathVariable String empId){
        return new ResponseEntity<>(iemployeeSeervice.getEmployeeByEmail(empId), HttpStatus.OK);
    }

    @GetMapping("/getcustomerbyproductname/{empId}")
    public ResponseEntity<?> getEmployeeDepartment(@PathVariable String empId){
        return new ResponseEntity<>(iemployeeSeervice.getEmployeeByDept(empId), HttpStatus.OK);
    }





}
