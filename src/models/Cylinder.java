package models;

/**
 * Class description:
 * 
 * @author Keith Fong 000881410
 *
 */
public class Cylinder extends Shape {

	/**
	 * Initializes the newly created Cylinder
	 */

	public Cylinder(String type, double height, double length) {
		super(type, height, length);

	}

	@Override
	public double volume() {
		// Volume = height * pi x r^2
		return super.getHeight() * super.getLength() * super.getLength() * 3.14;
	}

	@Override
	public double area() {
		// Base area = pi x r^2
		return super.getLength() * super.getLength() * 3.14;
	}

}
