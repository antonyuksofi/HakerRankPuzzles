package puzzles.greedyalgorithms;

import org.junit.Test;
import puzzles.greedyalgorithms.MinimumAbsoluteDifference;

import static org.junit.Assert.*;

public class MinimumAbsoluteDifferenceTest {

    @Test
    public void testMinimumAbsoluteDifference() throws Exception {
        assertEquals(1, MinimumAbsoluteDifference.minimumAbsoluteDifference(
                new int[] {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}
        ));
    }
}