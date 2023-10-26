package org.example.hellomaven;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest extends Calculator {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }
    @Test
    void addition(){
        double result = calculator.add(10,20.50);
        assertEquals(30.50,result);
        assertNotEquals(34.00,result);
    }

    @Test
    void subtraction(){
        double result = calculator.subtract(10.50,30);
        assertEquals(-19.50,result);
        assertNotEquals(3.50,result);
    }

    @Test
    void multiplication(){
        double result = calculator.multiply(10.00,20.00);
        assertEquals(200.00,result);
        assertNotEquals(342.00,result);
    }

    @Test
    void division(){
        double result = calculator.divide(10,20);
        assertEquals(0.5,result);
        assertNotEquals(342,result);
    }
    @Test
    void modulo(){
        double result = calculator.modulo(10,20);
        assertEquals(10,result);
        assertNotEquals(342,result);
    }
}
