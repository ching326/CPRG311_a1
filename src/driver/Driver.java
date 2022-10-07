package driver;

import java.io.*;
import java.util.Scanner;

import models.*;
import utilities.*;

/**
 * Class description: Application Driver
 * 
 * @author Keith Fong 000881410
 *
 */
public class Driver {

	/**
	 * Main Method
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter file name, compare type and sort type");
		String line = userInput.nextLine().toLowerCase();

		// Examples for userInput:
		// java -jar sort.jar -fpolyfor1.txt -Th -Sz
		// java -jar sort.jar -Ta -Sb -fpolyfor1.txt
		// java -jar sort.jar -Tv -fpolyfor1.txt -Ss

		String path = line.substring(line.indexOf("-f") + 2, line.indexOf("txt") + 3);
		String compareType = line.substring(line.indexOf("-t") + 2, line.indexOf("-t") + 3);
		String sortType = line.substring(line.indexOf("-s") + 2, line.indexOf("-s") + 3);

		File file = new File("res/" + path);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Please enter correct filename begin with -f");

			e.printStackTrace();
		}
		int totalShapeNum = scanner.nextInt();
		Shape[] shapes = new Shape[totalShapeNum];

		System.out.println("File name: " + path);
		System.out.println("Compare Type: " + compareType);
		System.out.println("Sort Type: " + sortType);

		for (int i = 0; i < totalShapeNum; i++) {
			scanner.useDelimiter(" ");
			String type = scanner.next();
			double height = scanner.nextDouble();
			double length = scanner.nextDouble();

			if (type.equals("Cone")) {
				shapes[i] = new Cone(type, height, length);
			}

			if (type.equals("Cylinder")) {
				shapes[i] = new Cylinder(type, height, length);
			}

			if (type.equals("OctagonalPrism")) {
				shapes[i] = new OctagonalPrism(type, height, length);
			}

			if (type.equals("PentagonalPrism")) {
				shapes[i] = new PentagonalPrism(type, height, length);
			}

			if (type.equals("Pyramid")) {
				shapes[i] = new Pyramid(type, height, length);
			}

			if (type.equals("SquarePrism")) {
				shapes[i] = new SquarePrism(type, height, length);
			}

			if (type.equals("TriangularPrism")) {
				shapes[i] = new TriangularPrism(type, height, length);
			}

		}

		// Driver method to test above

		Sort sort = new Sort();
		AreaCompare ac = new AreaCompare();
		VolumeCompare vc = new VolumeCompare();

		switch (compareType) {
		case "a":
			sort.setComparator(ac);
			break;
		case "v":
			sort.setComparator(vc);
			break;
		case "h":
			sort.setComparator(null);
			break;
		default:
			System.out.println("Please enter correct comparison -v -a -h");
			System.exit(0);
		}

		long start = System.currentTimeMillis();

		switch (sortType) {
		case "b":
			sort.bubbleSort(shapes);
			break;
		case "s":
			sort.selectionSort(shapes);
			break;
		case "i":
			sort.insertionSort(shapes);
			break;
		case "m":
			sort.mergeSort(shapes, 0, shapes.length - 1);
			break;
		case "q":
			sort.quickSort(shapes, 0, shapes.length - 1);
			break;
		case "z":
			sort.minMaxSort(shapes, shapes.length);
			break;
		default:
			System.out.println("Please enter correct sorting -b -s -i -m -q -z");
			System.exit(0);
		}

		long end = System.currentTimeMillis();
		long duration = (end - start);

		System.out.println("Used time for sorting: " + duration + " milliseconds");
		sort.printArray(shapes);
	}
}
