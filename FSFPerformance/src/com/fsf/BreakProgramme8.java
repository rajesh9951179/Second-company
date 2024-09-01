package com.fsf;

public class BreakProgramme8 {
	
	 public static void main(String[] args) {
	        for (int i = 1; i <= 10; i++) {
	            if (i == 5) {
	                break; // Exit the loop when i is 5
	            }
	            System.out.println(i);
	        }
	        System.out.println("Loop ended due to break statement.");
	    }

}
