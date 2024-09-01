package com.jsp;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Directory10Files {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\vijay\\Downloads";
        File[] files = new File(directoryPath).listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Specified directory does not exist, is not a directory, or is empty.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Press Enter for ascending order or enter 'd' for descending order: ");
        String order = scanner.nextLine();

        Comparator<File> comparator = Comparator.comparingLong(File::lastModified);
        if ("d".equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }

        Arrays.sort(files, comparator);

        int pageSize = 10;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        for (int i = 0; i < files.length; i += pageSize) {
            for (int j = 0; j < pageSize && i + j < files.length; j++) {
                File file = files[i + j];
                String fileName = file.getName();
                String lastModified = sdf.format(new Date(file.lastModified()));
                long fileSize = file.length();
                System.out.printf("%-30s %-20s %10d bytes%n", fileName, lastModified, fileSize);
            }

            if (i + pageSize < files.length) {
                System.out.print("Press Enter for next page, or enter 'q' to quit: ");
                String nextAction = scanner.nextLine();
                if ("q".equalsIgnoreCase(nextAction)) {
                    break;
                }
            } else {
                System.out.println("End of files reached.");
            }
        }

        scanner.close();
    }
}
