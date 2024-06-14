/*
DAY : 03
ASSIGNMENT : 03

Write a String reverse program that takes array of String as input from the
command-line arguments and reverse the String at each index.

 */

package net.texala.main;

public class StringReverse {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No input provided. Please provide strings as command-line arguments.");
            return;
        }

        System.out.println("Original Strings:");
        for (String original : args) {
            System.out.println(original);
        }

        System.out.println("\nReversed Strings:");
        for (String original : args) {
            String reversed = reverseString(original);
            System.out.println(reversed);
        }
    }

    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
