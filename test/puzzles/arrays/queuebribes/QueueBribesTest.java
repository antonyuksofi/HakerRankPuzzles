package puzzles.arrays.queuebribes;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueBribesTest {

    @Test
    public void testGetMinimumBribesAmount() {
        assertEquals(3, QueueBribes.getMinimumBribesAmount(new int[] {2, 1, 5, 3, 4}));
        assertEquals(-1, QueueBribes.getMinimumBribesAmount(new int[] {2, 5, 1, 3, 4}));
        assertEquals(7, QueueBribes.getMinimumBribesAmount(new int[] {1, 2, 5, 3, 7, 8, 6, 4}));
    }
}