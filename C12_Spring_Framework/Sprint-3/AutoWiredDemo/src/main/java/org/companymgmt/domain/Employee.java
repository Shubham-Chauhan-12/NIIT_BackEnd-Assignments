package org.companymgmt.domain;



import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Employee {
    private String name;
    private long mobileNo;
    private String address;
    @Autowired
    private Department dept;
    @Autowired
    private List<Education> edu;

    public Employee() {
    }

    public Employee(String name, long mobileNo, String address, Department dept, List<Education> edu) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.address = address;
        this.dept = dept;
        this.edu = edu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public List<Education> getEdu() {
        return edu;
    }

    public void setEdu(List<Education> edu) {
        this.edu = edu;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", mobileNo=" + mobileNo +
                ", address='" + address + '\'' +
                ", dept=" + dept +
                ", emp=" + edu +
                '}';
    }
}
