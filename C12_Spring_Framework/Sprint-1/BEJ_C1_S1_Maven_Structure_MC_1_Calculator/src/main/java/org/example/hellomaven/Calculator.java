package org.example.hellomaven;


public class Calculator {

    public double add(double num1, double num2)
    {
        return num1 + num2;
    }
    public double subtract(double num1, double num2)
    {
        return num1-num2;
    }
    public double multiply(double num1, double num2)
    {
        return num1*num2;
    }
    public double divide(double num1, double num2)
    {

        try {
            return num1 / num2;
        }
        catch (ArithmeticException e)
        {
            System.out.println(e.toString());
        }
        return 0.0;

    }
    public double modulo(double num1, double num2)
    {
        return num1 % num2;
    }

}











