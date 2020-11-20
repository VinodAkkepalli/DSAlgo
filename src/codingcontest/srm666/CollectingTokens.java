package codingcontest.srm666;

/**
 * 
 * @author VinodAkkepalli
 *
 *
 *
 *
Problem Statement <- this code is incomplete or has bugs
    
Surya has a tree with n nodes, numbered 1 through n. Each node contains some arbitrary nonnegative number of tokens.

Surya sometimes goes for a walk on the tree. He has to start his walk in node 1, but he may terminate it in any node of the tree. 
Surya gets tired easily: during the walk he is only able to traverse at most L edges.

Surya now wants to collect as many tokens as possible during a single walk. 
He can collect tokens in all nodes he visits, including the nodes where he starts and ends his walk. 
Obviously, the tokens in each node can only be collected once.

You are given the structure of the tree in int[]s A and B, each with n-1 elements. 
For each valid i the tree contains an edge between the nodes A[i] and B[i]. 
You are also given the int[] tokens with n elements. 
For each valid i, tokens[i] is the number of tokens in node i+1. Finally, you are given the int L.

Return the maximum number of tokens Surya can collect.
Definition
    
Class:
CollectingTokens
Method:
maxTokens
Parameters:
int[], int[], int[], int
Returns:
int
Method signature:
int maxTokens(int[] A, int[] B, int[] tokens, int L)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Constraints
-
n will be between 1 and 50, inclusive.
-
A and B will contain exactly n-1 elements each.
-
Each element of A and B will be between 1 and n, inclusive.
-
A and B will define a tree.
-
tokens will contain exactly n elements.
-
Each element of tokens will be between 1 and 100, inclusive.
-
L will be between 1 and 100, inclusive.
Examples
0)

    
{1}
{2}
{7,1}
6
Returns: 8
This tree consists of two nodes and a single edge. There are 7 tokens in node 1 and 1 token in node 2. 
Surya can make at most six steps, which is more than enough to collect all 7+1 = 8 tokens.
1)

    
{3,1}
{2,2}
{2,3,9}
5
Returns: 14

2)

    
{1,2,5,3}
{4,4,1,4}
{6,1,6,4,4}
3
Returns: 16
This is a tree with five nodes. 
One optimal walk for this tree is to start in node 1, go to node 4, then to node 3, and then back to node 4. 
As L=3, this is the longest walk Surya may make. 
During this walk he will collect 6 tokens in node 1, 4 tokens in node 4, 6 tokens in node 3, and then 0 tokens when revisiting node 4. 
The total is 6+4+6+0 = 16 tokens. Another optimal walk is to start in node 1, go to node 4, then to node 3, and to stop there. 
Surya is not required to make all L steps.
3)

    
{9,1,7,10,5,8,3,4,2}
{6,6,9,6,6,1,1,6,6}
{4,2,1,6,3,7,8,5,2,9}
4
Returns: 26

4)

    
{25,22,35,42,40,9,32,12,37,44,23,1,24,28,20,4,26,33,11,48,34,6,16,50,46,17,8,43,18,30,31,36,39,13,
10,45,3,47,15,2,29,19,7,14,41,49,38,27,21}
{5,5,25,25,25,42,25,40,5,35,25,32,42,9,32,23,40,25,20,33,26,37,12,1,48,24,22,25,11,24,48,34,18,9,50,42,16,40,1,
10,47,22,48,44,48,1,4,46,47}
{6,9,4,9,5,8,6,4,4,1,4,8,3,4,5,8,5,6,4,9,7,9,7,9,5,2,7,2,7,7,5,9,5,8,5,7,1,9,3,9,3,6,4,5,5,4,7,9,2,2}
48
Returns: 194

 *
 *
 */


public class CollectingTokens
{
	public int maxTokens(int[] A, int[] B, int[] tokens, int L)
	{
		
		return 0;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new CollectingTokens().maxTokens(new int[]{1}, new int[]{2}, new int[]{7,1}, 6);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 8;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new CollectingTokens().maxTokens(new int[]{3,1}, new int[]{2,2}, new int[]{2,3,9}, 5);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 14;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new CollectingTokens().maxTokens(new int[]{1,2,5,3}, new int[]{4,4,1,4}, new int[]{6,1,6,4,4}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 16;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new CollectingTokens().maxTokens(new int[]{9,1,7,10,5,8,3,4,2}, new int[]{6,6,9,6,6,1,1,6,6}, new int[]{4,2,1,6,3,7,8,5,2,9}, 4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 26;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new CollectingTokens().maxTokens(new int[]{25,22,35,42,40,9,32,12,37,44,23,1,24,28,20,4,26,33,11,48,34,6,16,50,46,17,8,43,18,30,31,36,39,13,10,45,3,47,15,2,29,19,7,14,41,49,38,27,21}, new int[]{5,5,25,25,25,42,25,40,5,35,25,32,42,9,32,23,40,25,20,33,26,37,12,1,48,24,22,25,11,24,48,34,18,9,50,42,16,40,1,10,47,22,48,44,48,1,4,46,47}, new int[]{6,9,4,9,5,8,6,4,4,1,4,8,3,4,5,8,5,6,4,9,7,9,7,9,5,2,7,2,7,7,5,9,5,8,5,7,1,9,3,9,3,6,4,5,5,4,7,9,2,2}, 48);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 194;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
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
