package practice.dynamicprogramming;

/**
 * 
 * @author Vinod Akkepalli
 *
 * Pascal Triangle
 * http://www.geeksforgeeks.org/pascal-triangle/
 *	input : 6
 *
 *	output:
  	  1 
     1 1 
    1 2 1 
   1 3 3 1 
  1 4 6 4 1 
 1 5 10 10 5 1 

 */

public class PascalTriangle {

	public static void main(String[] args) {
		
		// O(n^3). calculates c(n,r) to calculate values
		printPascal(6); 
		
		// O(n^2). uses dynamic programming to avoid recalculations
		// O(n^2). uses a 2D array to store calculated values 
		printPascalDP(7);
		
		// O(n^2). uses dynamic programming to avoid recalculations
		// O(1). uses a single variable to store previous value in the current row 
		printPascalDPOpt(8);
	}

	private static void printPascalDPOpt(int n) {

		int val = 1;
		for(int i=0; i<n;i++){
			for(int j=1; j <= n - i; j++){
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++){
				
				if(j == 0 || j == i){
					val = 1;
				}else{
					val = val * (i-j+1)/j;
				}
					
				System.out.print(val +" ");
			}
			System.out.println();
		}
		
	}

	private static void printPascalDP(int n) {

		int[][] arr = new int[n][n];
		
		for(int i=0; i<n;i++){
			for(int j=1; j <= n - i; j++){
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++){
				
				if(j == 0 || j == i){
					arr[i][j] = 1;
				}else{
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
					
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}

	private static void printPascal(int n){

		for(int i=0; i<n; i++){
			for(int j=1; j <= n - i; j++){
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++){
				System.out.print(mathCombination(i,j) +" ");
			}
			System.out.println();
		}
	}

	//method to find combination C(n,r) = n!/(n-r)! r!
	private static int mathCombination(int n, int r) {
		
		int numerator = 1, denominator = 1;
		for(int i=n; i>n-r; i--){
			numerator = numerator * i;
		}
		for(int i=1; i<=r; i++){
			denominator = denominator * i;
		}
		return numerator/denominator;
	}
}