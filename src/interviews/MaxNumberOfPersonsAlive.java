package interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Vinod Akkepalli
 *
 *         Problem Description: Given data (personName, yearOfBirth,
 *         yearOfDeath) for n persons Find the maximum count and the year in
 *         which maximum persons lived Given a list of people with their birth
 *         and end years (all between 1900 and 2000), find the year with the
 *         most number of people alive
 *         
 *         Total Time complexity is O(number of persons)
 */
public class MaxNumberOfPersonsAlive {

	public static void main(String[] args) {

		// int[][] sensusArray = {{1920, 1939}, {1911, 1944}, {1920, 1955}, {1938,1939}};
		int[][] sensusArray = { { 1920, 1939 }, { 1911, 1944 }, { 1920, 1955 }, { 1938, 1939 }, { 1937, 1940 } };
		findMaxYear(sensusArray);
	}

	// create separate births and deaths years array
	// TC is O(number of persons)
	static void findMaxYear(int[][] sensusArray) {
		// create List of births and deaths
		List<Integer> birthYears = new ArrayList<>();
		List<Integer> deathYears = new ArrayList<>();
		for (int[] personSensus : sensusArray) {
			birthYears.add(personSensus[0]);
			deathYears.add(personSensus[1]);
		}

		// System.out.println(birthYears);
		// System.out.println(deathYears);
		System.out.println("Year of most people alive : " + maxYear(birthYears, deathYears));
	}

	// in three linear passes finds out the year in which most people were alive
	// TC is O(number of persons)
	static int maxYear(List<Integer> births, List<Integer> deaths) {
		int counts[] = new int[101];
		for (int i : births)
			counts[i - 1900]++;
		for (int i : deaths)
			counts[i - 1900]--;

		int max = counts[0];
		int year = 0;
		int pop = counts[0];
		for (int i = 1; i < counts.length; i++) {
			pop += counts[i];
			if (pop > max) {
				max = pop;
				year = i;
			}
		}
		return year + 1900;
	}
}