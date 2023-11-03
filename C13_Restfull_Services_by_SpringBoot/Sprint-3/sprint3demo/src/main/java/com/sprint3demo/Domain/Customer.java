package com.sprint3demo.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Customer {

    @Id
    private int customerId;
    private String customerName;
    private Address customerAdd;
    private List<Product> productList;

    public Customer() {
    }

    public Customer(int customerId, String customerName, Address customerAdd, List<Product> productList) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAdd = customerAdd;
        this.productList = productList;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Address getCustomerAdd() {
        return customerAdd;
    }

    public void setCustomerAdd(Address customerAdd) {
        this.customerAdd = customerAdd;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
