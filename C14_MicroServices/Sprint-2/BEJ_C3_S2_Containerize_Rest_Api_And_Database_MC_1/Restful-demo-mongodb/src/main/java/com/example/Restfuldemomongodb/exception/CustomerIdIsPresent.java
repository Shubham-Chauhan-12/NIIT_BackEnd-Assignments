package com.example.Restfuldemomongodb.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "customer with this id is present in database try different id to store")
public class CustomerIdIsPresent extends Exception{
}
