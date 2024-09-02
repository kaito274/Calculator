package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

//This is a simple Calculator class that performs basic arithmetic operations.
public class Calculator {
    private Scanner scanner;
    private int a, b, n;

    // This method is named 'add'. It takes two integers as input (parameters) named 'a' and 'b'.
    // It prints out the sum of 'a' and 'b'.
    private void add(int a, int b) {
        int result = a + b;
        System.out.println("a + b = " + result);
    }

    // This method is named 'subtract'. It takes two integers as input (parameters) named 'a' and 'b'.
    // It prints out the result of 'a' subtracted by 'b'.
    private void subtract(int a, int b) {
        int result = a - b;
        System.out.println("a - b = " + result);
    }

    // This method is named 'multiply'. It takes two integers as input (parameters) named 'a' and 'b'.
    // It prints out the product of 'a' and 'b'.
    private void multiply(int a, int b) {
        long result = 1L * a * b;
        System.out.println("a * b = " + result);
    }

    // This method is named 'divide'. It takes two integers as input (parameters) named 'a' and 'b'.
    // It prints out the result of 'a' divided by 'b'.
    // If 'b' is zero, it throws an IllegalArgumentException. This is to prevent division by zero, which is undefined.
    private void divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }
        double result = (double) a / (double) b;
        System.out.println("a / b = " + result);
    }

    // This method is named 'modulo'. It takes two integers as input (parameters) named 'a' and 'b'.
    // It prints out the remainder of 'a' divided by 'b'.
    // If 'b' is zero, it throws an IllegalArgumentException. This is to prevent division by zero, which is undefined.
    private void modulo(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }
        int result = a % b;
        System.out.println("a % b = " + result);
    }

    // This method is named 'power'. It takes two integers as input (parameters) named 'a' and 'b'.
    // It prints out 'a' raised to the power of 'b'.
    // If 'b' is negative, it throws an IllegalArgumentException. This is to prevent complex numbers, which are not supported.
    private void power(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Exponent cannot be negative.");
        }
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        System.out.println("a ^ b = " + result);
    }

    // This method is named 'gcd_calculations'. It takes two integers as input (parameters) named 'a' and 'b'.
    // It returns the greatest common divisor of 'a' and 'b'.
    // It uses the Euclidean algorithm to calculate the GCD.
    private int gcd_calculations(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd_calculations(b, a % b);
        }
    }

    // This method is named 'gcd'. It takes two integers as input (parameters) named 'a' and 'b'.
    // It prints out the greatest common divisor of 'a' and 'b'.
    // If 'a' or 'b' is negative, it throws an IllegalArgumentException. This is to prevent negative numbers, which are not supported.
    private void gcd(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Integers cannot be negative.");
        }
        int result = gcd_calculations(a, b);
        System.out.println("GCD(a, b) = " + result);
    }

    // This method is named 'abs'. It takes an integer as input (parameter) named 'a'.
    // It returns the absolute value of 'a'.
    private int abs(int a) {
        return (a < 0) ? -a : a;
    }

    // This method is named 'lcm'. It takes two integers as input (parameters) named 'a' and 'b'.
    // It prints out the least common multiple of 'a' and 'b'.
    // It uses the formula: lcm(a, b) = |a * b| / gcd(a, b).
    private void lcm(int a, int b) {
        long result = 1L * abs(a) * abs(b) / gcd_calculations(a, b);
        System.out.println("LCM(a, b) = " + result);
    }

    // This method is named 'fibonacci'. It takes an integer as input (parameter) named 'n'.
    // It prints out the nth Fibonacci number.
    // If 'n' is negative, it throws an IllegalArgumentException. This is to prevent negative numbers, which are not supported.
    private void fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input cannot be negative.");
        }
        if (n == 0) {
            System.out.println("Fibonacci(0) = 0");
        } else if (n == 1) {
            System.out.println("Fibonacci(1) = 1");
        } else {
            int a = 0;
            int b = 1;
            for (int i = 2; i <= n; i++) {
                int c = a + b;
                a = b;
                b = c;
            }
            System.out.println("Fibonacci(" + n + ") = " + b);
        }
    }

    // This method is named 'displayGUI'. It prints out the calculator's user interface.
    private void displayGUI() {
        System.out.println("########  Welcome to the Calculator!  #######");
        System.out.println("Please select an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Modulo (%)");
        System.out.println("6. Power (^)");
        System.out.println("7. GCD");
        System.out.println("8. LCM");
        System.out.println("9. Fibonacci");
        System.out.println("0. Exit");
    }

    // This method is named 'inputOneIntegers'. It takes an integer as input (parameter) named 'n'.
    // It prompts the user to enter an integer 'n'.
    private void inputOneIntegers() {
        System.out.print("Enter an number (n): ");
        n = scanner.nextInt();
    }

    // This method is named 'inputTwoIntegers'. It takes two integers as input (parameters) named 'a' and 'b'.
    // It prompts the user to enter two integers 'a' and 'b'.
    private void inputTwoIntegers() {

        System.out.print("Enter the first number (a): ");
        a = scanner.nextInt();
        System.out.print("Enter the second number (b): ");
        b = scanner.nextInt();
    }

    // This method is named 'run'. It runs the calculator's user interface in an infinite loop.
    public void run() {
        scanner = new Scanner(System.in);
        try {
            while (true) {
                displayGUI();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    break;
                }
                switch (choice) {
                    case 1:
                        inputTwoIntegers();
                        add(a, b);
                        break;
                    case 2:
                        inputTwoIntegers();
                        subtract(a, b);
                        break;
                    case 3:
                        inputTwoIntegers();
                        multiply(a, b);
                        break;
                    case 4:
                        inputTwoIntegers();
                        divide(a, b);
                        break;
                    case 5:
                        inputTwoIntegers();
                        modulo(a, b);
                        break;
                    case 6:
                        inputTwoIntegers();
                        power(a, b);
                        break;
                    case 7:
                        inputTwoIntegers();
                        gcd(a, b);
                        break;
                    case 8:
                        inputTwoIntegers();
                        lcm(a, b);
                        break;
                    case 9:
                        inputOneIntegers();
                        fibonacci(n);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input only accepts integers -(2^63) -> (2^63 - 1).");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

}