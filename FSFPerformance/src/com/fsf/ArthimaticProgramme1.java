package com.fsf;

import java.util.Scanner;

public class ArthimaticProgramme1 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter first number: ");
	        int num1 = scanner.nextInt();

	        System.out.print("Enter second number: ");
	        int num2 = scanner.nextInt();

	        int sum = num1 + num2;
	        int difference = num1 - num2;
	        int product = num1 * num2;
	        int quotient = num1 / num2;
	        int remainder = num1 % num2;

	        System.out.println("Sum: " + sum);
	        System.out.println("Difference: " + difference);
	        System.out.println("Product: " + product);
	        System.out.println("Quotient: " + quotient);
	        System.out.println("Remainder: " + remainder);

	        scanner.close();
	    }

}
