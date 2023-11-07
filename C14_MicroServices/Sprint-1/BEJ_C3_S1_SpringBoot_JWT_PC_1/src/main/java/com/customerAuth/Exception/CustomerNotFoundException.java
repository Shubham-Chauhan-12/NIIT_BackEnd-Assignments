package com.customerAuth.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Customer not Found .....Please try again.")
public class CustomerNotFoundException extends Exception{
}
