package com.alogirthms;

public class SelectionSort {
    public static void main(String[] args) {
        int a[] = {4, 1, 3, 22, 9, 66};
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i; 
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
