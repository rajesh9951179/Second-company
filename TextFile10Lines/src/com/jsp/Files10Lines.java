package com.jsp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Files10Lines {
    private static final int LINES_PER_PAGE = 10;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\vijay\\Downloads\\file10lines.txt"))) {
            String line;
            int lineNumber = 0;
            boolean displayMore = true;

            while (displayMore) {
                for (int i = 0; i < LINES_PER_PAGE; i++) {
                    line = reader.readLine();
                    if (line != null) {
                        System.out.println(line);
                        lineNumber++;
                    } else {
                        displayMore = false;
                        break;
                    }
                }
                if (displayMore) {
                    System.out.print("Press Enter to display next " + LINES_PER_PAGE + " lines (Q to quit): ");
                    Scanner sc = new Scanner(System.in);
                    String userInput = sc.nextLine().trim().toLowerCase();
                    if (userInput.equals("q")) {
                        displayMore = false;
                    }
                }
            }

            System.out.println("End of file reached.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
