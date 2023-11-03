package com.sprint3demo.Domain;

public class Address {

    private int houseNo;
    private String streetName;
    private String state;

    public Address() {
    }

    public Address(int houseNo, String streetName, String state) {
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.state = state;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
