package models;

/**
 * Class description:
 * 
 * @author Keith Fong 000881410
 *
 */
public class Pyramid extends Shape {

	public Pyramid(String type, double height, double length) {
		super(type, height, length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double volume() {
		// Volume = side^2 * height /3
		return super.getHeight() * super.getLength() * super.getLength() / 3;
	}

	@Override
	public double area() {
		// Base area = side^2 *
		return super.getLength() * super.getLength();
	}

}
