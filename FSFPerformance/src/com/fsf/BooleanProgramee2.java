package com.fsf;

public class BooleanProgramee2 {
	  public static void main(String[] args) {
	        boolean hasLicense = true;
	        boolean hasInsurance = false;

	        // Check if a person can drive a car
	        if (hasLicense && hasInsurance) {
	            System.out.println("You can drive a car.");
	        } else {
	            System.out.println("You cannot drive a car.");
	        }

	        // Check if a person can ride a bicycle
	        boolean hasBicycle = true;
	        boolean isRaining = false;

	        if (hasBicycle && !isRaining) {
	            System.out.println("You can ride a bicycle.");
	        } else {
	            System.out.println("You cannot ride a bicycle.");
	        }
		
		
	}

}
