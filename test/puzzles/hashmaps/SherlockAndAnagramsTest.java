package puzzles.hashmaps;

import org.junit.Test;

import static org.junit.Assert.*;

public class SherlockAndAnagramsTest {

    @Test
    public void testSherlockAndAnagrams() throws Exception {
        assertEquals(4, SherlockAndAnagrams.sherlockAndAnagrams("abba"));
        assertEquals(3, SherlockAndAnagrams.sherlockAndAnagrams("ifailuhkqq"));
        assertEquals(10, SherlockAndAnagrams.sherlockAndAnagrams("aaaa"));
        assertEquals(0, SherlockAndAnagrams.sherlockAndAnagrams("abc"));
        assertEquals(399,SherlockAndAnagrams.sherlockAndAnagrams("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel"));
    }
}