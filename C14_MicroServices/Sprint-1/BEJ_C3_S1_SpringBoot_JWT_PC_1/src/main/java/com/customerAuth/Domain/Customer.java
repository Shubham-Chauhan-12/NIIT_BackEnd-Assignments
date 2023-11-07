package com.customerAuth.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue                               // Auto - generated the Id values
    private int customerId;
    private String customerName;
    private String password;
    private long phoneNo;


    public Customer() {

    }

    public Customer(int customerId, String customerName, String password, long phoneNo) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.password = password;
        this.phoneNo = phoneNo;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
