/*
DAY : 10
ASSIGNMENT NO:10

Write a test program (say TestCylinder) to test the Cylinder class created, as
given below. Method Overriding and Super: The subclass Cylinder inherits getArea() method
from its superclass circle. Try overriding the getArea() method in the subclass
Cylinder to compute the surface area (=2π×radius×height + 2×base-area) of
the cylinder instead of base area. That is, if getArea() is called by a Circle instance, it
returns the area. If getArea() is called by a Cylinder instance, it returns the surface area
of the cylinder.
If you override the getArea() in the subclass Cylinder, the getVolume() no longer
works. This is because the getVolume() uses the overridden getArea() method found
in the same class (Java runtime will search the superclass only if it cannot locate the method
in this class). Fix the getVolume().
Hint: After overridding the getArea() in subclass Cylinder, you can choose to invoke
the getArea() of the superclass Circle by calling super.getArea().

*/
package net.texala.main;

public class TestCylinder {
	public static void main(String[] args) {

		Cylinder c1 = new Cylinder();
		System.out.println("Cylinder:" + " radius=" + c1.getRadius() + " height=" + c1.getHeight() + " base area="
				+ c1.getArea() + " volume=" + c1.getVolume());

		Cylinder c2 = new Cylinder(10.0);
		System.out.println("Cylinder:" + " radius=" + c2.getRadius() + " height=" + c2.getHeight() + " base area="
				+ c2.getArea() + " volume=" + c2.getVolume());

		Cylinder c3 = new Cylinder(2.0, 10.0);
		System.out.println("Cylinder:" + " radius=" + c3.getRadius() + " height=" + c3.getHeight() + " base area="
				+ c3.getArea() + " volume=" + c3.getVolume());
	}
}
