package net.texala.main;
import static main.Constants.E;
import static main.Constants.PI;

public class CircleAreaCalculator {
	public static void main(String[] args) {
		double radius = 5.0;
		double area = PI*radius*radius;
		System.out.println("Area of circle : " +area);
		System.out.println("Euler's Number "+E);
	}
}
