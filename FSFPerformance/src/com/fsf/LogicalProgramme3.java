package com.fsf;

public class LogicalProgramme3 {
	 public static void main(String[] args) {
	        int age = 25;
	        boolean hasLicense = true;

	        // Check if the person is eligible to drive
	        if (age >= 18 && hasLicense) {
	            System.out.println("The person is eligible to drive.");
	        } else {
	            System.out.println("The person is not eligible to drive.");
	        }

	        // Check if the person is a teenager or has a driving license
	        if ((age >= 13 && age <= 19) || hasLicense) {
	            System.out.println("The person is either a teenager or has a driving license.");
	        } else {
	            System.out.println("The person is neither a teenager nor has a driving license.");
	        }

	        // Use of NOT operator
	        if (!hasLicense) {
	            System.out.println("The person does not have a driving license.");
	        } else {
	            System.out.println("The person has a driving license.");
	        }
	    }

}
