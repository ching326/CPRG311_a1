package models;

/**
 * Class description:
 * 
 * @author Keith Fong 000881410
 *
 */
public class TriangularPrism extends Shape {

	public TriangularPrism(String type, double height, double length) {
		super(type, height, length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double volume() {
		// Volume = height * side^2 x sqrt(3) / 4
		return super.getHeight() * super.getLength() * super.getLength() * Math.sqrt(3) / 4;
	}

	@Override
	public double area() {
		// Base area = side^2 x sqrt(3) / 4
		return super.getLength() * super.getLength() * Math.sqrt(3) / 4;
	}

}
