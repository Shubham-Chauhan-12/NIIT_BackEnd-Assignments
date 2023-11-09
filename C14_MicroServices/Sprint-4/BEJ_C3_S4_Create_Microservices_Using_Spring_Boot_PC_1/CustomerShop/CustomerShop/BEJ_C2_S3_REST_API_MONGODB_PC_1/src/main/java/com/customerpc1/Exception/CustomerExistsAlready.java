package com.customerpc1.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Customer with this Id already Exists")
public class CustomerExistsAlready extends Exception{
}
