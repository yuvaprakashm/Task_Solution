/*
DAY : 10
ASSIGNMENT NO : 12

Write two subclasses of Shape called Circle and Rectangle, as shown in the
class diagram. The Circle class contains the following.
·An instance variable radius (double).
·Three constructors as shown. The no-arg constructor initializes the radius to
1.0.
·Getter and setter for the instance variable radius.
·Methods getArea() and getPerimeter().
·Override the toString() method inherited, to return A Circle with
radius=xxx, which is a subclass of yyy, where yyy is the output
of the toString() method from the superclass.
The Rectangle class contains the following.
·Two instance variables width (double) and length (double).
·Three constructors as shown. The no-arg constructor initializes the width and
length to 1.0.
·Getter and setter for all the instance variables.
·Methods getArea() and getPerimeter().
·Override the toString() method inherited, to return A Rectangle with
width=xxx and length=zzz, which is a subclass of yyy,
where yyy is the output of the toString() method from the superclass.


*/
package net.texala.main;

public class TestShapes {
	public static void main(String[] args) {

		Shape shape1 = new Shape();
		System.out.println("shape1: " + shape1);

		Shape shape2 = new Shape("blue", false);
		System.out.println("shape2: " + shape2);

		Circle circle1 = new Circle();
		System.out.println("circle1: " + circle1);
		System.out.println("Area of circle1: " + circle1.getArea());
		System.out.println("Perimeter of circle1: " + circle1.getPerimeter());

		Circle circle2 = new Circle(5.0);
		System.out.println("circle2: " + circle2);
		System.out.println("Area of circle2: " + circle2.getArea());
		System.out.println("Perimeter of circle2: " + circle2.getPerimeter());

		Circle circle3 = new Circle("red", true, 3.0);
		System.out.println("circle3: " + circle3);
		System.out.println("Area of circle3: " + circle3.getArea());
		System.out.println("Perimeter of circle3: " + circle3.getPerimeter());

		Rectangle rectangle1 = new Rectangle();
		System.out.println("rectangle1: " + rectangle1);
		System.out.println("Area of rectangle1: " + rectangle1.getArea());
		System.out.println("Perimeter of rectangle1: " + rectangle1.getPerimeter());

		Rectangle rectangle2 = new Rectangle(4.0, 6.0);
		System.out.println("rectangle2: " + rectangle2);
		System.out.println("Area of rectangle2: " + rectangle2.getArea());
		System.out.println("Perimeter of rectangle2: " + rectangle2.getPerimeter());

		Rectangle rectangle3 = new Rectangle("purple", false, 2.0, 4.0);
		System.out.println("rectangle3: " + rectangle3);
		System.out.println("Area of rectangle3: " + rectangle3.getArea());
		System.out.println("Perimeter of rectangle3: " + rectangle3.getPerimeter());
	}
}