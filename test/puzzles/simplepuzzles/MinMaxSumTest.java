package puzzles.simplepuzzles;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinMaxSumTest {

    @Test
    public void testMiniMaxSum() throws Exception {

        int intermediateEl = 10;
        int[] input = new int[] {Integer.MIN_VALUE, intermediateEl, Integer.MAX_VALUE};

        assertArrayEquals(new long[] {Integer.MIN_VALUE + intermediateEl, Integer.MAX_VALUE + (long)intermediateEl},
                MinMaxSum.miniMaxSum(input));
    }
}