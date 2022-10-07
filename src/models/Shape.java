package models;

public abstract class Shape implements Comparable<Shape> {

	private String type;
	private double height;
	private double length;

	public Shape(String type, double height, double length) {
		this.type = type;
		this.height = height;
		this.length = length;
	}

	/**
	 * @return the area
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 * @param area the area to set
	 */
	public void setType(double String, String type) {
		this.type = type;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the volume
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	public abstract double volume();

	public abstract double area();

	@Override
	public int compareTo(Shape that) {

		// < > are reverse, because of descending order
		if (this.height < that.height) {
			return 1;
		} else if (this.height > that.height) {
			return -1;
		} else {
			return 0;
		}
	}

	public String toString() {
		return type + "" + height + "" + length;

	}
}
