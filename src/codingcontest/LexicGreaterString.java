package codingcontest;
/*
 * Problem Statement:
 * Greatest String: You are given a string S and an integer Q. You are allowed to
 * perform at most Q operations on the string. In one operation, you can change
 * any vowel to it's next character (e.g., 'a'->'b', 'e'->'f', 'i'->'j',
 * 'o'->'p', 'u'->'b'). Generate the lexicographically greatest string by
 * performing at most Q operations on string S.
 * 
 */

/**
 * @author Vinod Akkepalli
 *
 */

public class LexicGreaterString {

	public static void main(String[] args) {

		System.out.println(findLexicGreaterString("abcde".toCharArray(), 3)); // ans: bbcdf
		// System.out.println(solution("abidd".toCharArray(), 1)); // ans: bbidd
	}

	// solution with TC O(length of string)
	/**
	 * @param charArray
	 *            input string as charArray
	 * @param n
	 *            is Number of operations allowed
	 * @return returns the lexicographically greatest string after performing
	 *         maximum n number of operations
	 */
	private static char[] findLexicGreaterString(char[] charArray, int n) {

		int length = charArray.length;
		int count = 0;
		String VOWELS = "aeiou";
		for (int i = 0; i < length; i++) {
			if (count < n && VOWELS.indexOf(charArray[i]) > -1) {
				charArray[i] = (char) (charArray[i] + 1);
				count++;
			}
		}

		return charArray;
	}

}
