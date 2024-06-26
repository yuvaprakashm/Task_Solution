package net.texala.main;

public class Circle {
	private double radius;
	private String color;

	public Circle() {
		this.radius = 1.0;
		this.color = "red";
	}

	public Circle(double radius) {
		this.radius = radius;
		this.color = "blue";
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + "]";
	}
}
