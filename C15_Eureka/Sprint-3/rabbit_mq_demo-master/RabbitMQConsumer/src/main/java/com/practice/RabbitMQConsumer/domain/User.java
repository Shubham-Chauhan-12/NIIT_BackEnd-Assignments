/*
 * Author Name: Rohit
 * Date: 09-12-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.practice.RabbitMQConsumer.domain;

import org.json.simple.JSONObject;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.annotation.Generated;


@Document
public class User {

    private int userId;
    private String userName;
    private String password;
    private long mobileNo;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }
}
