package puzzles.simplepuzzles;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeftRotationTest {

    @Test
    public void testRotate() throws Exception {
        assertArrayEquals(new int[]{3, 4, 5, 1, 2}, LeftRotation.rotate(2, new int[]{1, 2, 3, 4, 5,}));
    }
}