package org.companymgmt;


import org.companymgmt.config.employeeConfig;
import org.companymgmt.domain.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(employeeConfig.class);
        Employee emp = (Employee) context.getBean("employee1");
        System.out.println(emp);
    }
}
