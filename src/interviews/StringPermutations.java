package interviews;

/**
 * 
 * @author Vinod Akkepalli
 *
 *         Problem Description: Print all permutations of a given string
 *         Solution is based on backtracking and recursion
 *         https://www.youtube.com/watch?v=MQcwxQK2DPA&list=PL65BCEDD6788C3F27
 *         https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 *         
 *         Print only distinct permutations:
 *         https://www.geeksforgeeks.org/distinct-permutations-string-set-2/
 */

public class StringPermutations {

	public static void main(String[] args) {
		String str = "ABCD";
		System.out.println("All possible permutations are: ");
		printPermutations(str, 0, str.length() - 1);

		String str1 = "ABCA";
		System.out.println("Distict permutations are: ");
		printDistinctPermutations(str1, 0, str1.length() - 1);
	}

	// TC O( n * n!)
	private static void printPermutations(String str, int left, int right) {
		if (left == right) {
			System.out.println(str);
			return;
		}

		for (int i = left; i <= right; i++) {
			str = swap(str, left, i);
			printPermutations(str, left + 1, right);
			str = swap(str, left, i);
		}
	}

	// TC O( n * n!)
	private static void printDistinctPermutations(String str, int left, int right) {
		if (left >= right) {
			System.out.println(str);
			return;
		}

		for (int i = left; i <= right; i++) {

			// Proceed further for str.charAt(i) only if it doesn't match with
			// any of the characters after str.charAt(left)
			if (shouldSwap(str, left, i, right)) {
				str = swap(str, left, i);
				printDistinctPermutations(str, left + 1, right);
				str = swap(str, left, i);
			}
		}
	}

	// Returns true if str.charAt(curr) matches with any of the
	// characters after str.charAt(start)
	private static boolean shouldSwap(String str, int start, int curr, int n) {
		for (int i = start; i < curr; i++) {
			if (str.charAt(i) == str.charAt(curr)) {
				return false;
			}
		}
		return true;
	}

	private static String swap(String str, int i, int j) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
