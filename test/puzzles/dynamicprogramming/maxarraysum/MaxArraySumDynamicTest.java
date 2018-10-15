package puzzles.dynamicprogramming.maxarraysum;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxArraySumDynamicTest {

    @Test
    public void testMaxSubsetSumWithPositiveNumbers() {
        assertEquals(9, MaxArraySumDynamic.maxSubsetSum(new int[] {5, 4, 3, 2, 1}));
        assertEquals(12, MaxArraySumDynamic.maxSubsetSum(new int[] {6, 5, 4, 3, 2, 1}));
    }

    @Test
    public void testMaxSubsetSumWithNegativeNumbers() {
        assertEquals(-1, MaxArraySumDynamic.maxSubsetSum(new int[] {-1, -2, -3, -4, -5}));
        assertEquals(0, MaxArraySumDynamic.maxSubsetSum(new int[] {-1, -2, -3, -4, -5, 0}));
    }

    @Test
    public void testMaxSubsetSumWithPositiveAndNegativeNumbers() {
        assertEquals(7, MaxArraySumDynamic.maxSubsetSum(new int[] {-1, 2, -3, -4, 5, 0}));
        assertEquals(6, MaxArraySumDynamic.maxSubsetSum(new int[] {-1, 2, -3, 4, -5, 0}));
        assertEquals(4, MaxArraySumDynamic.maxSubsetSum(new int[] {-1, -2, -3, 4, -5, 0}));
        assertEquals(4, MaxArraySumDynamic.maxSubsetSum(new int[] {-1, -2, -3, 4, -5}));
    }
}