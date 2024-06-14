/*
DAY : 10
ASSSIGNMENT NO : 14

Write a Java program to show that private member of a super class cannot be
accessed from derived classes.

*/
package net.texala.main;

public class Main {
    public static void main(String[] args) {
        Superclass superClassObj = new Superclass(42);
        superClassObj.display();

       
         Subclass subclassObj = new Subclass(24);
        subclassObj.displayInSubclass();
    }
}



/*
Scanner scanner = new Scanner(System.in);

 
System.out.print("Enter an integer for Superclass: ");
int superValue = scanner.nextInt();
Superclass superClassObj = new Superclass(superValue);
 
System.out.println("Superclass Information:");
superClassObj.display();
 
System.out.print("Enter an integer for Subclass: ");
int subValue = scanner.nextInt();
Subclass subclassObj = new Subclass(subValue);
 
System.out.println("\nSubclass Information:");
subclassObj.displayInSubclass();
 
scanner.close();
}
}


*/