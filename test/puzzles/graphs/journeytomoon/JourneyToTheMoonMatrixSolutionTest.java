package puzzles.graphs.journeytomoon;

import org.junit.Test;

import static org.junit.Assert.*;

public class JourneyToTheMoonMatrixSolutionTest {

    @Test
    public void testGetJourneyToMoonPairs() throws Exception {
        JourneyToTheMoon solution = new JourneyToTheMoonMatrixSolution();

        assertEquals(3, solution.getJourneyToMoonPairs(4, new int[][] {
                {0, 2},
                {0, 3},
                {2, 3},
        }));
    }
}