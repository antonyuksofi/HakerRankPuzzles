package puzzles.greedyalgorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreedyFloristTest {

    @Test
    public void testGetMinimumCost() throws Exception {
        assertEquals(13, GreedyFlorist.getMinimumCost(3, new int[] {2, 5, 6}));
        assertEquals(15, GreedyFlorist.getMinimumCost(2, new int[] {2, 5, 6}));
        assertEquals(29, GreedyFlorist.getMinimumCost(3, new int[] {1, 3, 5, 7, 9}));
    }
}