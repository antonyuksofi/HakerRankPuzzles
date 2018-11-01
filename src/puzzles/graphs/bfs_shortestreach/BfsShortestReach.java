package puzzles.graphs.bfs_shortestreach;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BfsShortestReach {
    static int[] bfsShortestReach(int nodesAmount, int edgesAmount, int[][] edges, int startNode, int edgeWeight) {
        int[] distancesFromStart = new int[nodesAmount];

        boolean[][] graph = getGraphMatrixFromEdges(nodesAmount, edges);

        Arrays.fill(distancesFromStart, -1);
        distancesFromStart[startNode - 1] = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>() {{
            this.add(startNode - 1);
        }};
        while (!queue.isEmpty()) {
            bfs(graph, queue, distancesFromStart);
        }

        int[] resultDistancesFromStart = new int[nodesAmount - 1];
        System.arraycopy(distancesFromStart, 0, resultDistancesFromStart, 0, startNode - 1);
        System.arraycopy(distancesFromStart, startNode, resultDistancesFromStart, startNode - 1, nodesAmount - startNode);

        multiplyDistanceOnEdgeWeight(resultDistancesFromStart, edgeWeight);

        return resultDistancesFromStart;
    }

    static void multiplyDistanceOnEdgeWeight(int[] distances, int edgeWeight) {
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] != -1) {
                distances[i] *= edgeWeight;
            }
        }
    }

    static void bfs(boolean[][] graph, ArrayDeque<Integer> queue, int[] distancesFromStart) {
        if (queue.isEmpty()) {
            return;
        }
        int currentNode = queue.poll();
        for (int adjacentNode = 0; adjacentNode < graph[currentNode].length; adjacentNode++) {
            if (graph[currentNode][adjacentNode] &&
                    distancesFromStart[adjacentNode] == -1) {
                queue.add(adjacentNode);
                distancesFromStart[adjacentNode] = distancesFromStart[currentNode] + 1;
            }
        }
    }

    static boolean[][] getGraphMatrixFromEdges(int nodesAmount, int[][] edges) {
        boolean[][] graph = new boolean[nodesAmount][nodesAmount];
        for (int[] edge : edges) {
            graph[edge[0] - 1][edge[1] - 1] = graph[edge[1] - 1][edge[0] - 1] = true;
        }

        return graph;
    }
}
