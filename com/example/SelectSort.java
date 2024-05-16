
package com.example;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Change me.
 *
 * @author Spencer Scarlett
 * @version 1.0
 * @since 2024-05-16
 */

// SelectSort class
public final class SelectSort {

    /** Private constructor to prevent instantiation. */
    private SelectSort() {
        throw new UnsupportedOperationException("Cannot instantiate");
    }

    /**
     * This is the main method.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {
        final String inputFile = "input.txt";
        final String outputFile = "output.txt";
        try {
            // Open input and output files
            final Scanner sc = new Scanner(new File(inputFile));
            final FileWriter fW = new FileWriter(outputFile);
            final PrintWriter write = new PrintWriter(fW);

            // Process each line in the input file
            while (sc.hasNextLine()) {
                // Read a line of integers separated by spaces
                String StrLine = sc.nextLine();
                try {
                    // Split the line into individual integers
                    String[] StrClean = StrLine.split(" ");
                    int[] arrayNum = new int[StrClean.length];
                    // Convert strings to integers and store them in an array
                    for (int i = 0; i < StrClean.length; i++) {
                        arrayNum[i] = Integer.parseInt(StrClean[i]);
                    }

                    // Perform insertion sort on the array
                    sort(arrayNum);

                    // Write the sorted array to the output file
                    for (int num : arrayNum) {
                        write.print(num + " ");
                    }
                    // Adds newline after each array
                    write.println();
                } catch (NumberFormatException error) {
                    // Handle exception if input is not properly formatted
                    System.out.println("Input must be separated by spaces");
                }
            }
            // Close input and output files
            write.close();
            sc.close();
            System.out.println("Done");
        } catch (Exception e) {
            // Handle exception if there is an issue with file I/O
            System.out.println("Invalid file path");
        }
    }

    static void sort(int arrayNum[])
    {
        int n = arrayNum.length;

        // One by one move boundary of unsorted sub array
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arrayNum[j] < arrayNum[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arrayNum[min_idx];
            arrayNum[min_idx] = arrayNum[i];
            arrayNum[i] = temp;
        }
    }
}
