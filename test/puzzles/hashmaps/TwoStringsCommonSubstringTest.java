package puzzles.hashmaps;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoStringsCommonSubstringTest {

    @Test
    public void testTwoStrings() throws Exception {
        assertEquals("YES", TwoStringsCommonSubstring.twoStrings("hello", "world"));
        assertEquals("YES", TwoStringsCommonSubstring.twoStrings("book", "cool"));
        assertEquals("NO", TwoStringsCommonSubstring.twoStrings("abc", "def"));
    }
}