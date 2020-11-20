package practice.arrays;

/**
 * 
 * @author Vinod Akkepalli
 *
 *         Problem statement: You are given an array of n+2 elements. All
 *         elements of the array are in range 1 to n. And all elements occur
 *         once except two numbers which occur twice. Find the two repeating
 *         numbers.
 *
 *         https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 */

public class FindRepeatingNumbers {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 4, 5, 2, 3, 1, 1 };
		int arr_size = arr.length;
		printRepeatingNumbers(arr, arr_size);
		printRepeatingNumbers1(arr, arr_size);
	}

	// Takes Count Array to store number of occurrence. TC O(n) SC O(n)
	static void printRepeatingNumbers(int[] arr, int size) {
		int[] count = new int[size];
		int i;

		System.out.print("Repeated elements are : ");
		for (i = 0; i < size; i++) {
			if (count[arr[i]] == 1)
				System.out.print(arr[i] + " ");
			else
				count[arr[i]]++;
		}
		System.out.println();
	}

	// Uses array elements as Index. TC O(n) SC O(1)
	static void printRepeatingNumbers1(int[] arr, int size) {
		int i;
		System.out.print("Repeated elements are : ");

		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + " ");
		}
		System.out.println();
	}
}
