package arrays;

import java.util.Arrays;

/**
 * Problem Description: https://www.geeksforgeeks.org/k-numbers-difference-maximum-minimum-k-number-minimized/
 * @author Vinod Akkepalli
 */

public class MinUnfairness {
  
   public static void main(String[] args) throws NumberFormatException {
      int numPackets = 7;
      int numKids = 3;
      int[] packets = {10, 100, 300, 200, 1000, 20, 30};
      
      int unfairness = Integer.MAX_VALUE;
      
      Arrays.sort(packets);
      int i = 0, temp = 0;
      
      int startLimit = numPackets - numKids;
      while(i < startLimit){
    	  temp = packets[i+numKids-1] - packets[i];
    	  if (temp < unfairness) unfairness = temp; 
    	  i++;
      }
      
      System.out.println(unfairness);
   }
}
