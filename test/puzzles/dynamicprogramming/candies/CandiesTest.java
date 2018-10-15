package puzzles.dynamicprogramming.candies;

import org.junit.Test;

import static org.junit.Assert.*;

public class CandiesTest {

    @Test
    public void testCandies() throws Exception {
        assertEquals(4, Candies.candies(new int[]{1, 2, 2}));
        assertEquals(19, Candies.candies(new int[]{2, 4, 2, 6, 1, 7, 8, 9, 2, 1}));
    }
}