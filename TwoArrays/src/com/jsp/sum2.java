package com.jsp;
import java.util.HashSet;
public class sum2 {
    public static boolean twoArraySum(int[] arr, int target) {
        HashSet<Integer> number = new HashSet<>();
       // int[] arr = {1,4,2,5,26,9};
        for (int num : arr) {
        	 int check = target - num; //5-1=4 ; 4 //
        	
           if (number.contains(check)) 
           {
        	 return true;
        	           
           }
        	            
       number.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,26,9};
        int target = 5;

        boolean b = twoArraySum(arr, target);
        
        if (b==true) {
            System.out.println("two arrays sum : " + b);
        } else {
            System.out.println("two arrays not sum :"+b);
        }
    }
}
