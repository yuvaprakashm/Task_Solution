package net.texala.main;

public class Square extends Rectangle {

	public Square(double side) {
		super(side, side);
	}

	@Override
	public void setLength(double side) {
		super.setLength(side);
		super.setWidth(side);
	}

	@Override
	public void setWidth(double side) {
		super.setWidth(side);
		super.setLength(side);
	}

	@Override
	public String toString() {
		return "A Square with side=" + getWidth() + ", which is a subclass of " + super.toString();
	}
}