package org.example.hellomaven;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Fibonacci obj = new Fibonacci();

        System.out.print("Enter the Length ? ");
        int length = sc.nextInt();

        int printSeries[] = obj.fibonacciSeries(length);
        System.out.print("Fibonacci Series = ");

        for (int i = 0; i < length; i++) {

            System.out.print(printSeries[i] + " ");

        }

    }
}
