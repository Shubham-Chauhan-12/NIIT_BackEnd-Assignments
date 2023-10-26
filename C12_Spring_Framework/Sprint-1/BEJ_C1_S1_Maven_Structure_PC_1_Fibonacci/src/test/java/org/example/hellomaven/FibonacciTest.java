package org.example.hellomaven;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    Fibonacci fibonacci;

    @Before
    public void setUp() throws Exception {
        fibonacci = new Fibonacci();
    }

    @After
    public void tearDown() throws Exception {
        fibonacci = null;
    }

    @Test
    public void checkingFibonacciValues(){
        int checkSeries[] = fibonacci.fibonacciSeries(8);
        int valueExpected[] = {0,1,1,2,3,5,8,13};
        assertArrayEquals(valueExpected,checkSeries);

    }
}