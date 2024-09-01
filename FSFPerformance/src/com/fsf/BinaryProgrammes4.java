package com.fsf;

public class BinaryProgrammes4 {
	public static void main(String[] args) {
		
		  String binary = "11001";
	        int decimal = Integer.parseInt(binary, 2);
	        System.out.println("Binary: " + binary);
	        System.out.println("Decimal: " + decimal);
	        
	        int decimals = 25;
	        String binarys = Integer.toBinaryString(decimals);
	        System.out.println("Decimal: " + decimals);
	        System.out.println("Binary: " + binarys);
	        
        String binary1 = "101"; // 5 in decimal
        String binary2 = "110"; // 6 in decimal

        // Convert binary strings to decimal integers
        int num1 = Integer.parseInt(binary1, 2);
        int num2 = Integer.parseInt(binary2, 2);
        System.out.println(num1);
        System.out.println(num2);
        
        // Perform multiplication
        int product = num1 * num2;

        // Convert result back to binary
        String binaryProduct = Integer.toBinaryString(product);
        System.out.println("Product of " + binary1 + " and " + binary2 + " is " + binaryProduct);
    }

}
