package puzzles.graphs.journeytomoon;

import org.junit.Test;

import static org.junit.Assert.*;

public class JourneyToTheMoonSetsSolutionTest {

    @Test
    public void testGetJourneyToMoonPairs() throws Exception {
        JourneyToTheMoon solution = new JourneyToTheMoonSetsSolution();

        assertEquals(3, solution.getJourneyToMoonPairs(4, new int[][] {
                {0, 2},
                {0, 3},
                {2, 3},
        }));

        assertEquals(10, solution.getJourneyToMoonPairs(7, new int[][] {
                {1, 2},
                {2, 3},
                {1, 4},
                {5, 4},
                {0, 6},
        }));

        assertEquals(24, solution.getJourneyToMoonPairs(9, new int[][] {
                {1, 2},
                {2, 3},
                {1, 4},
                {5, 4},
                {0, 6},
                {7, 8},
        }));

    }
}