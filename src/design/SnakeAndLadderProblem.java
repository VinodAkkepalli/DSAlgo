package design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>Description</b> :
 * Given a snake and ladder board, find the minimum number of dice throws required to reach
 * the destination or last cell from source or 1st cell. Basically, the player has total control
 * over outcome of dice throw and wants to find out minimum number of throws required to reach
 * last cell.
 *
 * https://www.geeksforgeeks.org/snake-ladder-problem-2/
 *
 * @author Vinod Akkepalli
 */

public class SnakeAndLadderProblem {

    public static void main(String[] args) {
        // Let us construct the board given in above diagram
        int boardSize = 30;
        int[] moves = new int[boardSize];
        Arrays.fill(moves, -1);

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, boardSize));
    }

    static int getMinDiceThrows(int[] move, int boardSize) {
        boolean[] visited = new boolean[boardSize];
        Queue<QEntry> queue = new LinkedList<>();
        QEntry entry = new QEntry();
        entry.vNumber = 0;
        entry.distance = 0;

        visited[0] = true;
        queue.add(entry);

        // Do a BFS starting from vertex at index 0
        while (!queue.isEmpty()) {
            entry = queue.remove();
            int vNumber = entry.vNumber;

            if (vNumber == boardSize - 1) {
                break;
            }

            for (int j = vNumber + 1; j <= (vNumber + 6) && j < boardSize; ++j) {
                if (!visited[j]) {
                    // Otherwise calculate its distance and mark it as visited
                    QEntry qEntry = new QEntry();
                    qEntry.distance = (entry.distance + 1);
                    visited[j] = true;

                    // Check if there a snake or ladder at 'j' then tail of snake
                    // or top of ladder become the adjacent of 'i'
                    qEntry.vNumber = (move[j] != -1) ? move[j] : j;
                    queue.add(qEntry);
                }
            }
        }

        // We reach here when 'entry' has last vertex
        // return the distance of vertex in 'entry'
        return entry.distance;
    }
}

// An entry in queue used in BFS
class QEntry {
    int vNumber;// Vertex number
    int distance;// Distance of this vertex from source
}