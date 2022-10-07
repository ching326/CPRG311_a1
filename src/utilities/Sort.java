package utilities;

import java.text.DecimalFormat;
import java.util.Comparator;

import models.Shape;

/**
 * Class description: Sorting algorithm
 * 
 * @author Keith Fong 000881410
 *
 */
public class Sort {

	/**
	 * Initializes the newly created Sort
	 * 
	 * @param <T>
	 */

	private static final DecimalFormat df = new DecimalFormat("#,###.##");

	static Comparator<Shape> comparator;

	public void setComparator(Comparator<Shape> comparator) {
		this.comparator = comparator;
	}

	// bubbleSort
	/**
	 * bubbleSort
	 * 
	 * @param <T>
	 * @param shapes
	 */
	public <T> void bubbleSort(Shape[] shapes) {

		// Compare Height
		if (comparator == null) {
			int n = shapes.length;
			for (int i = 0; i < n - 1; i++)
				for (int j = 0; j < n - i - 1; j++)
					if (shapes[j].compareTo(shapes[j + 1]) > 0) {
						// swap arr[j+1] and arr[j]
						Shape temp = shapes[j];
						shapes[j] = shapes[j + 1];
						shapes[j + 1] = temp;
					}
		}

		// Compare Volume or Area
		else {
			int n = shapes.length;
			for (int i = 0; i < n - 1; i++)
				for (int j = 0; j < n - i - 1; j++)
					if (comparator.compare(shapes[j], shapes[j + 1]) > 0) {
						// swap arr[j+1] and arr[j]
						Shape temp = shapes[j];
						shapes[j] = shapes[j + 1];
						shapes[j + 1] = temp;
					}
		}
	}

	// selectionSort
	public <T> void selectionSort(Shape[] shapes) {

		// Compare Height
		if (comparator == null) {
			int n = shapes.length;
			for (int i = 0; i < n - 1; i++) {
				// Find the minimum element in unsorted array
				int min_idx = i;
				for (int j = i + 1; j < n; j++)
					if (shapes[j].compareTo(shapes[min_idx]) < 0)
						min_idx = j;

				// Swap the found minimum element with the first
				// element
				Shape temp = shapes[min_idx];
				shapes[min_idx] = shapes[i];
				shapes[i] = temp;
			}
		}

		// Compare Volume or Area
		else {
			int n = shapes.length;
			for (int i = 0; i < n - 1; i++) {
				// Find the minimum element in unsorted array
				int min_idx = i;
				for (int j = i + 1; j < n; j++)
					if (comparator.compare(shapes[j], shapes[min_idx]) < 0)
						min_idx = j;

				// Swap the found minimum element with the first
				// element
				Shape temp = shapes[min_idx];
				shapes[min_idx] = shapes[i];
				shapes[i] = temp;
			}
		}
	}

	// insertionSort
	public <T> void insertionSort(Shape[] shapes) {

		// Compare Height
		if (comparator == null) {
			int n = shapes.length;
			for (int i = 1; i < n; ++i) {
				Shape key = shapes[i];
				int j = i - 1;
				// Move elements of shapes[0..i-1], that are greater than key, to one position
				// ahead of their current position
				while (j >= 0 && (shapes[j].compareTo(key)) > 0) {
					shapes[j + 1] = shapes[j];
					j = j - 1;
				}
				shapes[j + 1] = key;
			}
		}

		// Compare Volume or Area
		else {
			int n = shapes.length;
			for (int i = 1; i < n; ++i) {
				Shape key = shapes[i];
				int j = i - 1;
				// Move elements of shapes[0..i-1], that are greater than key, to one position
				// ahead of their current position
				while (j >= 0 && (comparator.compare(shapes[j], key) > 0)) {
					shapes[j + 1] = shapes[j];
					j = j - 1;
				}
				shapes[j + 1] = key;
			}
		}
	}

	// mergeSort not work

	void merge(Shape[] shapes, int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		Shape L[] = new Shape[n1];
		Shape R[] = new Shape[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = shapes[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = shapes[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;

		// Compare Height
		if (comparator == null) {

			while (i < n1 && j < n2) {
				if (L[i].compareTo(R[j]) <= 0) {
					shapes[k] = L[i];
					i++;
				} else {
					shapes[k] = R[j];
					j++;
				}
				k++;
			}
		}

		// Compare Volume or Area
		else {
			while (i < n1 && j < n2) {
				if (comparator.compare(L[i], R[j]) <= 0) {
					shapes[k] = L[i];
					i++;
				} else {
					shapes[k] = R[j];
					j++;
				}
				k++;
			}
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			shapes[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			shapes[k] = R[j];
			j++;
			k++;
		}
	}

	public <T> void mergeSort(Shape[] shapes, int l, int r) {

		if (l < r)

		{
			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			mergeSort(shapes, l, m);
			mergeSort(shapes, m + 1, r);

			// Merge the sorted halves
			merge(shapes, l, m, r);
		}

	}

	public static int partition(Shape[] shapes, int low, int high) {

		// choose the rightmost element as pivot
		Shape pivot = shapes[high];

		// pointer for greater element
		int i = (low - 1);

		// traverse through all elements
		// compare each element with pivot

		// Compare Height
		if (comparator == null) {
			for (int j = low; j < high; j++) {
				if (shapes[j].compareTo(pivot) <= 0) {

					// if element smaller than pivot is found
					// swap it with the greatr element pointed by i
					i++;

					// swapping element at i with element at j
					Shape temp = shapes[i];
					shapes[i] = shapes[j];
					shapes[j] = temp;
				}
			}
		}

		// Compare Volume or Area
		else {

			for (int j = low; j < high; j++) {
				if (comparator.compare(shapes[j], pivot) <= 0) {

					// if element smaller than pivot is found
					// swap it with the greatr element pointed by i
					i++;

					// swapping element at i with element at j
					Shape temp = shapes[i];
					shapes[i] = shapes[j];
					shapes[j] = temp;

				}
			}
		}

		// swapt the pivot element with the greater element specified by i
		Shape temp = shapes[i + 1];
		shapes[i + 1] = shapes[high];
		shapes[high] = temp;

		// return the position from where partition is done
		return (i + 1);

	}

	public <T> void quickSort(Shape[] shapes, int low, int high) {

		if (low < high) {

			// find pivot element such that
			// elements smaller than pivot are on the left
			// elements greater than pivot are on the right
			int pi = partition(shapes, low, high);

			// recursive call on the left of pivot
			quickSort(shapes, low, pi - 1);

			// recursive call on the right of pivot
			quickSort(shapes, pi + 1, high);
		}

	}

	static Shape[] swap(Shape[] shapes, int i, int j) {
		Shape temp = shapes[i];
		shapes[i] = shapes[j];
		shapes[j] = temp;
		return shapes;
	}

	public <T> void minMaxSort(Shape[] shapes, int n) {

		for (int i = 0, j = n - 1; i < j; i++, j--) {
			Shape min = shapes[i], max = shapes[i];
			int min_i = i, max_i = i;

			// Compare Height
			if (comparator == null) {
				for (int k = i; k <= j; k++) {
					if (shapes[k].compareTo(max) > 0) {
						max = shapes[k];
						max_i = k;
					}

					else if (shapes[k].compareTo(min) < 0) {
						min = shapes[k];
						min_i = k;
					}
				}
			}

			// Compare Volume or Area
			else {
				for (int k = i; k <= j; k++) {
					if (comparator.compare(shapes[k], max) > 0) {
						max = shapes[k];
						max_i = k;
					}

					else if (comparator.compare(shapes[k], min) < 0) {
						min = shapes[k];
						min_i = k;
					}
				}
			}

			// shifting the min.
			swap(shapes, i, min_i);

			// Shifting the max. The equal condition
			// happens if we shifted the max to arr[min_i]
			// in the previous swap.
			if (shapes[min_i] == max)
				swap(shapes, j, min_i);
			else
				swap(shapes, j, max_i);
		}
	}

	// Prints the array
	public void printArray(Shape[] shapes) {
		int n = shapes.length;
		int step = 1000;
		// 1st
		System.out.println(1 + "\t" + shapes[0].getType() + "\t" + df.format(shapes[0].getHeight()) + "\t"
				+ df.format(shapes[0].area()) + "\t" + df.format(shapes[0].volume()));

		// every thousandth
		for (int i = 1000; i < n; i += step) {
			System.out.println(i + "\t" + shapes[i].getType() + "\t" + df.format(shapes[i].getHeight()) + "\t"
					+ df.format(shapes[i].area()) + "\t" + df.format(shapes[i].volume()));
		}

		// last
		System.out.println(n + "\t" + shapes[n - 1].getType() + "\t" + df.format(shapes[n - 1].getHeight()) + "\t"
				+ df.format(shapes[n - 1].area()) + "\t" + df.format(shapes[n - 1].volume()));

	}

}
