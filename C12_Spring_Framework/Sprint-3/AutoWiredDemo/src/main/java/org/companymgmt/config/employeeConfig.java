package org.companymgmt.config;

import org.companymgmt.domain.Department;
import org.companymgmt.domain.Education;
import org.companymgmt.domain.Employee;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class employeeConfig {
    @Bean("employee1")
    public Employee getDetails1(){
        Employee employee = new Employee();
        employee.setName("Peter");
        employee.setMobileNo(897845561223L);
        employee.setAddress("California");
        return employee;
    }

    @Bean
    public Department getDepartment1(){
        Department department = new Department();
        department.setDepartment("Development");
        department.setDesignation("Software Developer");
        department.setSalary(125000L);
        return department;
    }

    @Bean
    public Education getEducationDetail(){
        Education education = new Education();
        education.setQualification("Mtech");
        education.setCategory("Technical");
        return education;
    }
}
