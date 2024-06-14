/*
DAY : 8
ASSIGNMENT NO : 06

Write a program in Java that compares two text files line by line. The command line
should look like as given below.
java fileComp file1 file2 [limit]
Read in a line from each file and compare the two lines. If they are identical, continue
with the next two lines. Otherwise, write out the line number and the two lines, and
continue.
Frequently when two files differ then there are many lines that are different and you
do not want to see them all. The last argument, limit, is optional (that is what the
brackets mean). It is an integer that says how many pairs of different lines to write
before quitting. If limit is omitted, all differing lines are written. Catch the
NumberFormatException that may be thrown if limit cannot be converted.

*/
package net.texala.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileComparator {

    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("Usage: java FileComparator <file1> <file2> [limit]");
            return;
        }

        String file1 = args[0];
        String file2 = args[1];
        int limit = -1;

        if (args.length == 3) {
            try {
                limit = Integer.parseInt(args[2]);
                if (limit < 0) {
                    System.out.println("Invalid limit value. Using default limit.");
                    limit = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid limit format. Using default limit.");
            }
        }

        compareFiles(file1, file2, limit);
    }

    private static void compareFiles(String file1, String file2, int limit) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {

            int lineNumber = 0;
            int differencesCount = 0;
            String line1, line2;

            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                lineNumber++;

                if (!line1.equals(line2)) {
                    System.out.println("Difference at line " + lineNumber + ":");
                    System.out.println(file1 + ": " + line1);
                    System.out.println(file2 + ": " + line2);
                    System.out.println();

                    differencesCount++;

                    if (limit != -1 && differencesCount >= limit) {
                        System.out.println("Exceeded limit. Stopping comparison.");
                        break;
                    }
                }
            }

            System.out.println("Comparison completed. Total differences found: " + differencesCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

