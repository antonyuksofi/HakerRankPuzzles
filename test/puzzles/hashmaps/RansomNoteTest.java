package puzzles.hashmaps;

import org.junit.Test;

import static org.junit.Assert.*;

public class RansomNoteTest {

    @Test
    public void testCheckMagazine() throws Exception {

        assertEquals("Yes", RansomNote.checkMagazine(
                new String[] {"this", "is", "the", "simplest", "test", "of", "all"},
                new String[] {"this", "is", "the", "simplest", "test"}));

        assertEquals("No", RansomNote.checkMagazine(
                new String[] {"this", "is", "the", "simplest", "test", "of", "all"},
                new String[] {"this", "is", "the", "very", "simplest", "test"}));
    }
}