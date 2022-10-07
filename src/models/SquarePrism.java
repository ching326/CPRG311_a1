package models;

/**
 * Class description:
 * 
 * @author Keith Fong 000881410
 *
 */
public class SquarePrism extends Shape {

	public SquarePrism(String type, double height, double length) {
		super(type, height, length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double volume() {
		// Volume = height * side^2
		return super.getHeight() * super.getLength() * super.getLength();
	}

	@Override
	public double area() {
		// Base area = side^2
		return super.getLength() * super.getLength();
	}

}
