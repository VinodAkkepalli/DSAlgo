package arrays.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * LeetCode#649. Dota2 Senate
 * https://leetcode.com/problems/dota2-senate
 */

public class PredictPartyVictory {
    public static void main(String[] args) {

        // String senate = "RD"; //ans = "Radiant"
        // String senate = "RDD"; //ans = "Dire"
        String senate = "DDRRR"; //ans = "Dire"
        // String senate = "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"; //ans = "Dire"
        // String senate = "R"; //ans = "Radiant"
        // String senate = "RDRDRDRRRDRDRRRDRRDRRRRRDRRRRDDDD"; //ans = "Radiant"

        System.out.println(predictPartyVictory(senate));
        
    }

    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        
        // Add the initial indices of the senators to their respective queues
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        
        // Simulate the rounds until one party has no senators left
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();
            
            // The senator with the smaller index acts first.
            // They survive and move to the next round, so we add 'n' to their index.
            if (rIndex < dIndex) {
                radiant.offer(rIndex + n);
            } else {
                dire.offer(dIndex + n);
            }
        }
        
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
