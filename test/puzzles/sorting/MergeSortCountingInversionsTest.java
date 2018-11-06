package puzzles.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortCountingInversionsTest {

    @Test
    public void testCountInversions() throws Exception {
        assertEquals(2, MergeSortCountingInversions.countInversions(new int[]{2, 4, 1}));
        assertEquals(6, MergeSortCountingInversions.countInversions(new int[]{9, 8, 7, 6}));
    }

    @Test
    public void testMergeSortWithCounter() throws Exception {
        assertArrayEquals(new int[]{6, 7, 8, 9},
                MergeSortCountingInversions.mergeSortWithCounter(new int[]{9, 8, 7, 6}));
        assertArrayEquals(new int[]{1, 2, 4},
                MergeSortCountingInversions.mergeSortWithCounter(new int[]{2, 4, 1}));
    }

    @Test
    public void testMerge() throws Exception {
        assertArrayEquals(new int[]{1, 2, 4},
                MergeSortCountingInversions.merge(new int[]{2, 4}, new int[] {1}));
    }
}