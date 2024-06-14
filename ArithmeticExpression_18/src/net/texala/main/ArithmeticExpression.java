/*
 
Day: 01
Assignment No: 18

Exercise on Translation of Arithmetic Expression We can take a=1 b=2 c=3 x=4 and y= 5 or any other Numeric values.
Hint:int x=1;
int y=2;
int a=3;
int b=4;

 */

package net.texala.main;

public class ArithmeticExpression {
	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		int a = 3;
		int b = 4;
		int c = x * y + a + b;
		System.out.println("The result for the expression is :" + c);
	}
}
