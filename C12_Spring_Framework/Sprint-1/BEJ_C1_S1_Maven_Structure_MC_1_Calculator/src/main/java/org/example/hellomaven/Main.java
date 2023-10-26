package org.example.hellomaven;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char operator;
        Scanner sc = new Scanner(System.in);
        Calculator obj = new Calculator();

        while (true) {
            System.out.println("---------Please Select Calculator Operator------------");
            System.out.println("        +  ,  -  ,  *  , /  , %  , Q = Quit          ");
            operator = sc.next().charAt(0);

            if (operator == 'Q') {
                System.exit(0);
                System.out.println("Exit........");
            }
            else {
                System.out.println("Enter Number 1 ?");
                double num1 = sc.nextDouble();
                System.out.println("Enter Number 2 ?");
                double num2 = sc.nextDouble();

                switch (operator) {
                    case '+':
                        System.out.println("Result " + obj.add(num1, num2));
                        break;

                    case '-':
                        System.out.println("Result " + obj.subtract(num1, num2));
                        break;

                    case '*':
                        System.out.println("Result " + obj.multiply(num1, num2));
                        break;

                    case '/':
                        System.out.println("Result " + obj.divide(num1, num2));
                        break;

                    case '%':
                        System.out.println("Result " + obj.modulo(num1, num2));
                        break;

                    default:
                        System.out.println("Invalid Operator Please try again");
                }
            }
        }
    }
}
