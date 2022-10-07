package models;

/**
 * Class description:
 * 
 * @author Keith Fong 000881410
 *
 */
public class OctagonalPrism extends Shape {

	public OctagonalPrism(String type, double height, double length) {
		super(type, height, length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double volume() {
		// Volume = height * 5 x side^2 x Math.tan(54) / 4
		return super.getHeight() * 2 * (1 + Math.sqrt(2)) * super.getLength() * super.getLength();
	}

	@Override
	public double area() {
		// Base area = 2 x (1 + Math.sqrt(2)) side^2
		return 2 * (1 + Math.sqrt(2)) * super.getLength() * super.getLength();
	}

}
