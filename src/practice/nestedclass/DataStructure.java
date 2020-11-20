package practice.nestedclass;

import java.util.function.*;

/**
 * 
 * @author Vinod Akkepalli
 *
 *         Problem Statement: This code is a solution to the sequential
 *         exercises on the tutorial here:
 *         https://docs.oracle.com/javase/tutorial/java/javaOO/QandE/nested-questions.html
 *
 */

public class DataStructure {

	// Create an array
	private final static int SIZE = 15;
	private int[] arrayOfInts = new int[SIZE];

	public DataStructure() {
		// fill the array with ascending integer values
		for (int i = 0; i < SIZE; i++) {
			arrayOfInts[i] = i;
		}
	}

	public void print(DataStructureIterator iterator) {
		// Print out values of even indices of the array
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

	private void print(Function<Integer, Boolean> function) {

		for (int i = 0; i < SIZE; ++i) {
			if ((function.apply(i))) {
				System.out.print(arrayOfInts[i] + " ");
			}
		}
		System.out.println();
	}

	private static boolean isEvenIndex(Integer i) {
		return i % 2 == 0;
	}

	private static boolean isOddIndex(Integer i) {
		return i % 2 == 1;
	}

	public void printEven() {

		// Print out values of even indices of the array
		DataStructureIterator iterator = this.new EvenIterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

	interface DataStructureIterator extends java.util.Iterator<Integer> {
	}

	// Inner class implements the DataStructureIterator interface,
	// which extends the Iterator<Integer> interface

	private class EvenIterator implements DataStructureIterator {

		// Start stepping through the array from the beginning
		private int nextIndex = 0;

		public boolean hasNext() {

			// Check if the current element is the last in the array
			return (nextIndex <= SIZE - 1);
		}

		public Integer next() {

			// Record a value of an even index of the array
			Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);

			// Get the next even element
			nextIndex += 2;
			return retValue;
		}
	}

	public static void main(String s[]) {

		// Fill the array with integer values and print out only
		// values of even indices
		DataStructure ds = new DataStructure();
		ds.printEven();

		/* print(DataStructureIterator) with inner class EvenIterator() */
		System.out.println("print(DataStructureIterator) with inner class EvenIterator()");
		ds.print(ds.new EvenIterator());

		/* print(DataStructureIterator) with Ananymous class */
		System.out.println("print(DataStructureIterator) with Ananymous class");
		ds.print(new DataStructureIterator() {

			// Start stepping through the array from the beginning
			private int nextIndex = 1;

			public boolean hasNext() {

				// Check if the current element is the last in the array
				return (nextIndex <= SIZE - 1);
			}

			public Integer next() {

				// Record a value of an even index of the array
				Integer retValue = Integer.valueOf(ds.arrayOfInts[nextIndex]);

				// Get the next even element
				nextIndex += 2;
				return retValue;
			}
		});

		/* print(Function) with Lambda expressions */
		System.out.println("print(Function) with Lambda expressions");
		ds.print(t -> {
			return t % 2 == 0;
		});
		ds.print(t -> t % 2 == 1);

		/* print(Function) with method references */
		System.out.println("print(Function) with method references");
		ds.print(DataStructure::isEvenIndex);
		ds.print(DataStructure::isOddIndex);

	}
}