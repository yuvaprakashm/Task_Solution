/*

Day : 02
ASSIGNMENT : 03

let’s suppose that you work for a beverage company. The company wants to know the optimal cost for a cylindrical container that holds a specified volume. Write a fragment of code that uses an ask-before-iterating loop. During each iteration of the loop, your code should ask the user to enter the volume and the radius of the cylinder. Compute and display the height and cost of the container. Use the following formulas, where V is the volume, r is the radius, h is the height, and C is the cost. Hint:
h=V/πr² C=2πr(r + h)
Use Math.pow (int num, int powervalue)

*/
package net.texala.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BeverageCompany {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char userinput;

        do {
            double volume = getValidNumberInput("Enter the volume of the cylindrical container (in cubic units): ", scanner);
            double radius = getValidNumberInput("Enter the radius of the cylindrical container (in units): ", scanner);

            double height = volume / (Math.PI * Math.pow(radius, 2));
            double cost = 2 * Math.PI * radius * (radius + height);

            System.out.println("Height of the cylindrical container: " + height);
            System.out.println("Cost of the cylindrical container: " + cost);

            System.out.println("Do you want to execute again (y/n)?");
            userinput = scanner.next().charAt(0);
        } while (userinput == 'y' || userinput == 'Y');

        scanner.close();
    }

    private static double getValidNumberInput(String message, Scanner scanner) {
        double input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(message);
                input = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  
            }
        }

        return input;
    }
}
