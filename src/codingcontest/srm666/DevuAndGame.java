package codingcontest.srm666;

/**
 * 
 * @author VinodAkkepalli
 *
 *
Problem Statement
    
Devu loves to play games. This problem is about a game he recently played. In the game there are n locations, numbered 0 through n-1. 
Each location has one entrance and one exit. You are given a int[] nextLevel with n elements. 
For each i, nextLevel[i] describes the exit from location i. 
If nextLevel[i] is a number between 0 and n-1, inclusive, it means that the exit from location i leads to the entrance of location nextLevel[i]. Otherwise, nextLevel[i] will be -1 and it means that if the player reaches this exit, they win the game.

Devu started the game by entering location 0. Return "Win" (quotes for clarity) if he can win the game. Otherwise, return "Lose". 
Note that the return value is case-sensitive.

Definition
    
Class:
DevuAndGame
Method:
canWin
Parameters:
int[]
Returns:
String
Method signature:
String canWin(int[] nextLevel)
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
nextLevel will have between 1 and 50 elements, inclusive.
-
Each element in nextLevel will be either -1 or will be between 0 and n - 1, inclusive.
Examples
0)

    
{1, -1}
Returns: "Win"
Devu will start in location 0. The exit from this location will bring him to location 1, and when he reaches the exit from location 1 he wins the game.
1)

    
{1, 0, -1}
Returns: "Lose"
Devu will go back and forth between locations 0 and 1. He is unable to reach the exit from location 2.
2)

    
{0, 1, 2}
Returns: "Lose"
The exit from location 0 leads back to location 0. Devu is unable to reach the other locations.
3)

    
{29,33,28,16,-1,11,10,14,6,31,7,35,34,8,15,17,26,12,13,22,1,20,2,21,-1,5,19,9,18,4,25,32,3,30,23,10,27}
Returns: "Win"
There can be multiple x such that nextLevel[x] is -1. In order to win the game, Devu has to reach any single location with this property.
4)

    
{17,43,20,41,42,15,18,35,-1,31,7,33,23,33,-1,-1,0,33,19,12,42,-1,-1,9,9,-1,39,-1,31,46,-1,20,44,41,-1,-1,12,-1,36,-1,-1,6,47,10,2,4,1,29}
Returns: "Win"

5)

    
{3, 1, 1, 2, -1, 4}
Returns: "Lose"
In this game, Devu will go from location 0 to location 3, from there to location 2, and from there to location 1. There he will get stuck, as the exit from location 1 leads back to location 1.
 *
 */

public class DevuAndGame
{
	public String canWin(int[] nextLevel)
	{
		int nLLen = nextLevel.length;
		int visited[] = new int[nLLen];
		
		int curNode = 0;
		
		while(visited[curNode] == 0){
			if(nextLevel[curNode] == -1){
				//System.out.println("Win");
				return "Win";
			}else{
				visited[curNode]=1;
				curNode = nextLevel[curNode];
			}
		}
		
		if(visited[curNode] != 0)
			return "Lose";
		return ""; 
	}
	
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new DevuAndGame().canWin(new int[]{1, -1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Win";
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
		answer = new DevuAndGame().canWin(new int[]{1, 0, -1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Lose";
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
		answer = new DevuAndGame().canWin(new int[]{0, 1, 2});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Lose";
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
		answer = new DevuAndGame().canWin(new int[]{29,33,28,16,-1,11,10,14,6,31,7,35,34,8,15,17,26,12,13,22,1,20,2,21,-1,5,19,9,18,4,25,32,3,30,23,10,27});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Win";
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
		answer = new DevuAndGame().canWin(new int[]{17,43,20,41,42,15,18,35,-1,31,7,33,23,33,-1,-1,0,33,19,12,42,-1,-1,9,9,-1,39,-1,31,46,-1,20,44,41,-1,-1,12,-1,36,-1,-1,6,47,10,2,4,1,29});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Win";
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
		answer = new DevuAndGame().canWin(new int[]{3, 1, 1, 2, -1, 4});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Lose";
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
