package puzzles.dynamicprogramming.maxarraysum;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MaxArraySumOnlyRecursionTest {
    @Test
    public void testMaxArraySum() {
        assertEquals(9, MaxArraySumOnlyRecursion.maxSubsetSum(new int[] {5, 4, 3, 2, 1}));
        assertEquals(12, MaxArraySumOnlyRecursion.maxSubsetSum(new int[] {6, 5, 4, 3, 2, 1}));
    }

    @Test
    public void testAddCurrentAndProceed() {
        ArrayList<ArrayList<Integer>> forTest = new ArrayList<ArrayList<Integer>>();
        MaxArraySumOnlyRecursion.enrichSetAndAddToList(new ArrayList<Integer>() {{
            add(5);
        }}, 0, new int[] {5, 4, 3, 2, 1}, forTest);
        for (ArrayList<Integer> sets : forTest) {
            for (Integer integer : sets) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testGetMaxSum() {
        assertEquals(15, MaxArraySumOnlyRecursion.getMaxSum(new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList<Integer>() {{
                    add(1);
                    add(2);
                    add(3);
                }});
                add(new ArrayList<Integer>() {{
                    add(4);
                    add(5);
                    add(6);
                }});
                add(new ArrayList<Integer>() {{
                    add(1);
                    add(1);
                    add(1);
                }});
            }
        }));
    }
}
