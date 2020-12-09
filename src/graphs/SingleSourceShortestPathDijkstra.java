package graphs;

/**
 * <b>Description</b> :
 * A Java program for Dijkstra's single source shortest path algorithm.
 * The program is for adjacency matrix representation of the graph
 *
 * https://www.youtube.com/watch?v=XB4MIexjvY0
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 *
 * @author Vinod Akkepalli
 */

public class SingleSourceShortestPathDijkstra {
    static final int numVertices = 9;

    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static int minDistance(int[] dist, Boolean[] sptSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int ver = 0; ver < numVertices; ver++)
            if (!sptSet[ver] && dist[ver] <= min) {
                min = dist[ver];
                minIndex = ver;
            }

        return minIndex;
    }

    // A utility function to print the constructed distance array
    static void printSolution(int[] dist) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < numVertices; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    static void dijkstra(int[][] graph, int src) {
//        dist[i] will hold the shortest distance from src to i
        int[] dist = new int[numVertices];

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean[] sptSet = new Boolean[numVertices];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < numVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < numVertices - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first iteration.
            int nearestVertex = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[nearestVertex] = true;

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int vertex = 0; vertex < numVertices; vertex++)

                // Update dist[vertex] only if is not in sptSet, there is an
                // edge from nearestVertex to vertex, and total weight of path from src to
                // vertex through nearestVertex is smaller than current value of dist[vertex]
                if (!sptSet[vertex] && graph[nearestVertex][vertex] != 0
                        && dist[nearestVertex] != Integer.MAX_VALUE
                        && dist[nearestVertex] + graph[nearestVertex][vertex] < dist[vertex])
                    dist[vertex] = dist[nearestVertex] + graph[nearestVertex][vertex];
        }

        // print the constructed distance array
        printSolution(dist);
    }

    // Driver method
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        dijkstra(graph, 0);

        dijkstra(graph, 5);

    }
}
