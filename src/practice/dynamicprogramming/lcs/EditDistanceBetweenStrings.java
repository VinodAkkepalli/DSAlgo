package practice.dynamicprogramming.lcs;

/**
 * 
 * @author Vinod Akkepalli 
 * 	Problem Description: Edit Distance Problem 
 * 		Given two strings str1 and str2. Find minimum number of edits (operations)
 *		required to convert str1 into str2. Allowed operations are:    Insert, Remove & Replace
 *      https://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 *      https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25
 */

public class EditDistanceBetweenStrings {

	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";
		System.out.println("#of edits using DP Approach: " + editDistDP(str1, str2, str1.length(), str2.length()));
		System.out.println("#of edits using Recursive Approach: " + editDistRec(str1, str2, str1.length(), str2.length()));
	}

	// Recursive approach with TC O(3^len1)
	static int editDistRec(String str1, String str2, int len1, int len2) {
		// If first string is empty, the only option is to
		// insert all characters of second string into first
		if (len1 == 0) {
			return len2;
		}

		// If second string is empty
		if (len2 == 0) {
			return len1;
		}

		// If last characters of two strings are same
		// Ignore last characters and get count for remaining strings.
		if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
			return editDistRec(str1, str2, len1 - 1, len2 - 1);
		}

		// consider all three operations on last character of first string, recursively
		return 1 + Math.min(editDistRec(str1, str2, len1, len2 - 1), // Insert
				Math.min(editDistRec(str1, str2, len1 - 1, len2), // Remove
						editDistRec(str1, str2, len1 - 1, len2 - 1)) // Replace
		);
	}

	// Dynamic Programming approach with TC O(len1*len2)
	static int editDistDP(String str1, String str2, int len1, int len2) {
		int[][] dist = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0) {
					dist[i][j] = j; // Min# operations = j
				} else if (j == 0) {
					dist[i][j] = i; // Min# operations = i
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dist[i][j] = dist[i - 1][j - 1];
				} else {
					dist[i][j] = 1 + Math.min(dist[i][j - 1], // Insert
							Math.min(dist[i - 1][j], // Remove
									dist[i - 1][j - 1])); // Replace
				}
			}
		}
		
		//for (int i = 0; i <= len1; i++) { System.out.println(Arrays.toString(dist[i])); }
		return dist[len1][len2];
	}
}
