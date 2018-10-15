package puzzles.simplepuzzles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DynamicArrayTest {

    @Test
    public void testDynamicArray() {
        int seqAmount = 2;
        List<List<Integer>> queries = new ArrayList<List<Integer>>(seqAmount) {
            {
                add(Arrays.asList(1, 0, 5));
                add(Arrays.asList(1, 1, 7));
                add(Arrays.asList(1, 0, 3));
                add(Arrays.asList(2, 1, 0));
                add(Arrays.asList(2, 1, 1));
            }
        };

        List<Integer> results = DynamicArray.dynamicArray(seqAmount, queries);
        assertEquals(Arrays.asList(7, 3), results);
    }

}