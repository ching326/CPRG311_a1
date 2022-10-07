package models;

/**
 * Class description:
 * 
 * @author Keith Fong 000881410
 *
 */
public class Cone extends Shape {

	/**
	 * Initializes the newly created Cylinder
	 */

	public Cone(String type, double height, double length) {
		super(type, height, length);

	}

	@Override
	public double volume() {
		// Volume = height * pi x r^2 x 1/3
		return super.getHeight() * super.getLength() * super.getLength() * 3.14 / 3;
	}

	@Override
	public double area() {
		// Base area = pi x r^2
		return super.getLength() * super.getLength() * 3.14;
	}

}
