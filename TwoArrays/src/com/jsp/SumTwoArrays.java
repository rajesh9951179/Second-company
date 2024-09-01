package com.jsp;
import java.util.Scanner;
import java.util.HashSet;

public class SumTwoArrays {
    public static boolean twoArraySum(int[] arr, int target) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int num : arr) {
            int check = target - num;
            if (numbers.contains(check)) {
                return true;
            }
            numbers.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6};
        Scanner scanner = new Scanner(System.in);
        while (true) { 
            System.out.print("enter the target number  or -1 exist  ");
            int target = scanner.nextInt();

            if (target == -1) {
                System.out.println("exist code sucessfully");
                break;
            }

            boolean result = twoArraySum(arr, target);

            if (result==true) {
                System.out.println("two arrays sum " + result);
            } else {
                System.out.println("two arrays is not sum "  + result);
            }
        }

      
    }
}
