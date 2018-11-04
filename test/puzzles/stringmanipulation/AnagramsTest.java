package puzzles.stringmanipulation;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AnagramsTest {

    @Test
    public void testGetAmountOfSymbolsToDeleteToMakeAnagram() throws Exception {
        assertEquals(8, Anagrams.getAmountOfSymbolsToDeleteToMakeAnagram("abbxxx", "aabyyy"));
    }

    @Test
    public void testSubtractCharMaps() throws Exception {
        Map<Character, Integer> first = new HashMap<Character, Integer>() {
            {
                put('a', 1);
                put('b', 2);
                put('c', 3);
            }
        };
        Map<Character, Integer> second = new HashMap<Character, Integer>() {
            {
                put('a', 2);
                put('b', 1);
                put('d', 3);
            }
        };
        assertEquals(4, Anagrams.subtractCharMaps(first, second));
    }

    @Test
    public void testGetCharsMapOfString() throws Exception {
        Map<Character, Integer> result = Anagrams.getCharsMapOfString("aabbbcccd");
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}