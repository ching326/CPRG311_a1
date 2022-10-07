package models;

/**
 * Class description:
 * 
 * @author Keith Fong 000881410
 *
 */
public class PentagonalPrism extends Shape {

	public PentagonalPrism(String type, double height, double length) {
		super(type, height, length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double volume() {
		// Volume = height * 5 x side^2 x Math.tan(54) / 4
		return super.getHeight() * 5 * super.getLength() * super.getLength() * Math.tan(54) / 4;
	}

	@Override
	public double area() {
		// Base area = 5 x side^2 x Math.tan(54) / 4
		return 5 * super.getLength() * super.getLength() * Math.tan(54) / 4;
	}

}
