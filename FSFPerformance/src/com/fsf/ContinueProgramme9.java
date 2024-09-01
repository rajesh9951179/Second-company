package com.fsf;

public class ContinueProgramme9 {
	 public static void main(String[] args) {
	        for (int i = 1; i <= 10; i++) {
	            if (i == 5) {
	                continue; // Skip the current iteration when i is 5
	            }
	            System.out.println(i);
	        }
	        System.out.println("Loop completed with continue statement.");
	    }

}
