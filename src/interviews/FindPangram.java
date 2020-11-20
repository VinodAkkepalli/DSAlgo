package interviews;

/**
 * 
 * @author Vinod Akkepalli
 *
 */

/*
 *  program to find if a given string is a pangram
 */

public class FindPangram {

	public static void main(String[] args) {

		String str = new String("We promptly judged antique ivory buckles for the next prize  ");
		
		if(isPangram1(str)){
			System.out.println("pangram");
		}else{
			System.out.println("not pangram");
		}
	}

	private static boolean isPangram(String str) {

		
		String str1 = str.toUpperCase();
		for(char c=65; c<=90;c++){
			if(str1.indexOf(c) == -1)
				return false;
		}
		return true;
	}

	//Traverse only once through the given string
	private static boolean isPangram1(String str) {

		boolean[] flag = new boolean[26];
		int length = str.length();
		//mark the flags array if char is present
		for(int i=0; i<length; i++) {
			final char c = str.charAt(i);

			if( c>='A' && c<='Z' ) {
				flag[c-'A'] = true;
			} else if(c>='a' && c<='z') {
				flag[c-'a'] = true;
			}
		}

		//Check if any char is missing
		for(int i=0; i<26; i++) {
			if(!flag[i]) {
				return false;
			}
		}
		return true;
	}
}
