package codingcontest.srm666;

/**
 * 
Problem Statement
    
Chandan loves to play with strings. He just learned a new operation: inserting one string X into another string Y.

When inserting X into Y, it is also allowed to place X at the beginning or at the end of Y. 
For example, there are exactly five ways how to insert the string "ab" into the string "????": you can produce one of the strings "ab????", "?ab???", "??ab??", "???ab?", and "????ab".

According to Chandan, a good string is a string that can be constructed in the following way: Initially, he takes the empty string "". 
Then, he performs a sequence of zero or more steps. In each step he inserts the string "ab" anywhere into the current string.

According to the above definition, the strings "ab", "aabb", and "aababb" are good while the strings "aab", "ba", and "abbb" are not good.

Chandan's friend Ravi came up with a String s. Ravi asked Chandan whether it is a good string. 
Return "Good" (quotes for clarity) if the string is good, or "Bad" if the string is not good.

Definition
    
Class:
GoodString
Method:
isGood
Parameters:
String
Returns:
String
Method signature:
String isGood(String s)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Stack limit (MB):
256
Constraints
-
s will contain between 1 and 50 characters, inclusive.
-
Each element of s will be either 'a' or 'b'.
Examples
0)

    
"ab"
Returns: "Good"
Chandan can start with an empty string and insert "ab".
1)

    
"aab"
Returns: "Bad"

2)

    
"aabb"
Returns: "Good"
Chandan can construct this string as follows: "" -> "ab" -> "aabb".
3)

    
"ababab"
Returns: "Good"
One way to construct this string is to append "ab" to the current string three times.
4)

    
"abaababababbaabbaaaabaababaabbabaaabbbbbbbb"
Returns: "Bad"

5)

    
"aaaaaaaabbbaaabaaabbabababababaabbbbaabbabbbbbbabb"
Returns: "Good"

 * 
 * 
 * 
 */


public class GoodString
{
	public String isGood(String s)
	{
		StringBuilder str = new StringBuilder(s);
		int index = 0;
		
		while(str.length() > 0){
			index = str.toString().indexOf("ab");

			if( ( index == -1) && str.length() > 0){
				return "Bad";
			}else{
				str.delete(index, index+2);
			}
		}
		
		return "Good";
	}
	
	// Another elegant solution with O(n) time complexity
	public String isGood1(String str) {
		
		int count = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == 'a') {
				count++;
			} else {
				count--;
			}
			
			if(count < 0) {
				break;
			}				
		}
		
		if(count ==0) {
			return "Good";
		}
		return "Bad";
	}
	
	
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new GoodString().isGood("ab");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Good";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new GoodString().isGood("aab");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Bad";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new GoodString().isGood("aabb");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Good";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new GoodString().isGood("ababab");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Good";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new GoodString().isGood("abaababababbaabbaaaabaababaabbabaaabbbbbbbb");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Bad";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new GoodString().isGood("aaaaaaaabbbaaabaaabbabababababaabbbbaabbabbbbbbabb");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Good";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
