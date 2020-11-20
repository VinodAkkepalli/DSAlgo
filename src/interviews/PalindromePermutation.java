package interviews;

/**
 * 
 * @author Vinod Akkepalli
 *
 */

/*
We are given a string composed of lowercase English letters. 
Figure out whether any anagram of the string can be a palindrome or not.

 Input Format 
A single line which contains the input string.
Each character of the string is a lowercase English letter.

Output Format 
A single line which contains YES or NO in uppercase.

Input:aaabbbb
Output: YES
Reason: A palindrome permutation of the given string is bbaaabb

 */
public class PalindromePermutation {

	public static void main(String[] args) {
         String inputString = new String("cdcdcdcdeeeef");
       
        String ans;
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        ans = (isPalindromePermutation(inputString))? "YES" : "NO";
        System.out.println(ans);
       
    }
    
    private static boolean isPalindromePermutation(String str){
        int[] charCount = new int[26];
        for(int i=0; i<str.length();i++){
            ++charCount[str.charAt(i)-97];
        }
        int flag = 0;
        //System.out.println(Arrays.toString(charCount));
        for(int value: charCount){
        	if(value%2 != 0){
        		++flag;
        	}
        }
        if(flag>1) 
        	return false;
        else 
        	return true;
    }
}
