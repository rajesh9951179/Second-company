package com.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class ThreadInputs1 extends Thread {
    private final List<String> inputs;

    public ThreadInputs1(List<String> inputs) {
        this.inputs = inputs;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter names (type 'stop' when finished):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }
            if (!input.isEmpty() && Character.isAlphabetic(input.charAt(0))) {
                synchronized (inputs) {
                    inputs.add(input);
                }
            } else {
                System.out.println("Invalid input. The first character must be an alphabetical character.");
            }
        }
        scanner.close(); 
        System.out.println("Input collection finished.");
    }
}

class ThreadSort1 extends Thread {
    private final List<String> inputs;

    public ThreadSort1(List<String> inputs) {
        this.inputs = inputs;
    }

    @Override
    public void run() {
        if (inputs.isEmpty()) {
            System.out.println("No input fields, sorting skipped.");
        } else {
            Collections.sort(inputs);
            System.out.println("Sorting... Please wait for 5 seconds.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           
            	
            System.out.println("Sorted order of inputs:");
            for (String s : inputs) {
                System.out.println(s);
            }
        }
        
    }
}

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        List<String> inputs = new ArrayList<>();
        ThreadInputs1 inputThread = new ThreadInputs1(inputs);
        ThreadSort1 sorterThread = new ThreadSort1(inputs);
        
        inputThread.start();
        inputThread.join();
        sorterThread.start();
     
    }
}
