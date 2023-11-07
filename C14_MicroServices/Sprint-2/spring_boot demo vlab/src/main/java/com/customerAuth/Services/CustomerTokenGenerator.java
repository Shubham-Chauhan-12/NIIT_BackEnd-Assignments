package com.customerAuth.Services;

import com.customerAuth.Domain.Customer;

import java.util.Map;

public interface CustomerTokenGenerator {

    Map<String,String> generateToken(Customer customer);

}
