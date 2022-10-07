package utilities;

import java.util.Comparator;

import models.Shape;

/**
 * Class description:
 * 
 * @author Keith Fong 000881410
 *
 */
public class VolumeCompare implements Comparator<Shape> {

	@Override
	public int compare(Shape s1, Shape s2) {

		// < and > are reverse, because of descending order
		if (s1.volume() < s2.volume()) {
			return 1;
		} else if (s1.volume() > s2.volume()) {
			return -1;
		} else {
			return 0;
		}
	}
}