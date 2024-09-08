package org.example;

import org.example.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Vector;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    // Set up the output stream
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.setOut(new PrintStream(outContent));
    }

    // Restore the output stream
    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        calculator = null;
    }


    @Test
    public void testAdd() {
        int a = 4;
        int b = 5;
        // Simulate user input
        String simulatedInput = "1\n" + a + "\n" + b + "\n0\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        calculator.run(); // Run the main method

        System.err.println(outContent.toString());
        assertTrue(outContent.toString().contains("a + b = 9"));
    }
//    @Test
//    public void testSubtract() {
//        calculator.subtract(10, 5); // Expected output: a - b = 5
//        assertEquals("a - b = 5\n", outContent.toString());
//    }
//
//    @Test
//    public void testMultiply() {
//        calculator.multiply(2, 3); // Expected output: a * b = 6
//        assertEquals("a * b = 6\n", outContent.toString());
//    }
//
//    @Test
//    public void testDivide() {
//        calculator.divide(10, 2); // Expected output: a / b = 5.0
//        assertEquals("a / b = 5.0\n", outContent.toString());
//    }
//
//    @Test
//    public void testGCD() {
//        calculator.gcd(12, 8); // Expected output: GCD(a, b) = 4
//        assertEquals("GCD(a, b) = 4\n", outContent.toString());
//    }
//
//    @Test
//    public void testFibonacci() {
//        calculator.fibonacci(5); // Expected output: Fibonacci(5) = 5
//        assertEquals("Fibonacci(5) = 5\n", outContent.toString());
//    }
}
