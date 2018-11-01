package puzzles.graphs.bfs_shortestreach;

import org.junit.Test;

import static org.junit.Assert.*;

public class BfsShortestReachTest {
    private static final int EDGE_WEIGHT = 6;

    @Test
    public void testBfsShortestReach() throws Exception {
        int[][] edges = new int[2][];
        edges[0] = new int[] {1, 2};
        edges[1] = new int[] {1, 3};
        assertArrayEquals(new int[] {6, 6, -1}, BfsShortestReach.bfsShortestReach(4, 2, edges, 1, EDGE_WEIGHT));
    }

    @Test
    public void testBfsShortestReach2() throws Exception {
        int[][] edges = new int[1][];
        edges[0] = new int[] {2, 3};
        assertArrayEquals(new int[] {-1, 6}, BfsShortestReach.bfsShortestReach(3, 1, edges, 2, EDGE_WEIGHT));
    }

    @Test
    public void testGetGraphMatrixFromEdges() {
        int[][] edges = new int[2][];
        edges[0] = new int[] {1, 2};
        edges[1] = new int[] {1, 3};
        BfsShortestReach.getGraphMatrixFromEdges(4, edges);
    }
}