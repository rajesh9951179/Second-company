package com.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class ThreadInputs extends Thread {
    private final List<String> inputs;
    private boolean running = true;
    private boolean newInputAdded = false;

    public ThreadInputs(List<String> inputs) {
        this.inputs = inputs;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter names (type 'stop' when finished):");
        while (running) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                running = false;
                break;
            } else if (!input.isEmpty() && input.chars().allMatch(c -> Character.isAlphabetic(c) || c == ' ')) {
                synchronized (inputs) {
                    inputs.add(input);
                    newInputAdded = true;
                }
            } else {
                System.out.println("Invalid input. Only alphabetic characters are allowed.");
            }
        }
        scanner.close();
    }

    public boolean hasNewInput() {
        return newInputAdded;
    }

    public void resetNewInputFlag() {
        newInputAdded = false;
    }

    public boolean isRunning() {
        return running;
    }
}

class ThreadSort extends Thread {
    private final List<String> inputs;
    private final ThreadInputs inputThread;
    private boolean running = true;

    public ThreadSort(List<String> inputs, ThreadInputs inputThread) {
        this.inputs = inputs;
        this.inputThread = inputThread;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(5000); // Sorting every 10 seconds
                synchronized (inputs) {
                    if (inputThread.hasNewInput() || !inputThread.isRunning()) {
                        Collections.sort(inputs);
                        System.out.println("Sorted order of inputs:");
                        Thread.sleep(1000);
                        for (String s : inputs) {
                            System.out.println(s);
                        }
                        inputThread.resetNewInputFlag(); // Reset the flag after sorting
                    }
                    if (!inputThread.isRunning() && !inputThread.hasNewInput()) {
                        running = false; // Stop the thread if no new inputs and input thread has stopped
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopSorting() {
        running = false;
    }
}

public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<String> inputs = new ArrayList<>();
        ThreadInputs inputThread = new ThreadInputs(inputs);
        ThreadSort sorterThread = new ThreadSort(inputs, inputThread);

        inputThread.start();
        sorterThread.start();

        inputThread.join(); // Wait for input thread to finish

//        synchronized (inputs) {
//            if (inputThread.hasNewInput() || !inputThread.isRunning()) {
//                Collections.sort(inputs);
//                System.out.println("Final sorted order of inputs:");
//                for (String s : inputs) {
//                    System.out.println(s);
//                }
//            }
//        }

        sorterThread.stopSorting(); // Stop the sorting thread
        sorterThread.join(); // Wait for sorting thread to finish
    }
}
