/*
 * Author Name: Rohit
 * Date: 09-12-2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.practice.UserProductService.Config;

import org.json.simple.JSONObject;

public class UserDTO {

    private int userId;
    private String userName;
    private String password;
    private long mobileNo;

    public UserDTO(int userId, String userName, String password, long mobileNo) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.mobileNo = mobileNo;
    }

    public UserDTO() {
    }

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
