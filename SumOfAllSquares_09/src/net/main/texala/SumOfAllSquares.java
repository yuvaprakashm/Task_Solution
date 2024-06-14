/*
 
Day: 01
Assignment No: 09

the program to find the "sum of the squares" of all the numbers from 1 to 100,
i.e. 1*1 + 2*2 + 3*3 + ... + 100*100 and find largest divisor of sum.


*/

package net.main.texala;

import java.util.Scanner;

public class SumOfAllSquares {

    public static void main(String[] args) {
        char userinput;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter the end value: ");
            int endValue = scanner.nextInt();

            long sumOfSquares = calculateSumOfSquares(endValue);
            System.out.println("Sum of the squares: " + sumOfSquares);

            int largestDivisor = findLargestDivisor(sumOfSquares);
            System.out.println("Largest divisor of the sum: " + largestDivisor);

            System.out.println("Do you want to execute again (y/n)?");
            userinput = scanner.next().charAt(0);

        } while (userinput == 'Y' || userinput == 'y');

        scanner.close();
    }

    private static long calculateSumOfSquares(int endValue) {
        long sum = 0;
        for (int i = 1; i <= endValue; i++) {
            sum += (long) i * i;  
        }
        return sum;
    }

    private static int findLargestDivisor(long number) {
        for (int i = (int) Math.sqrt(number); i > 1; i--) {
            if (number % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
