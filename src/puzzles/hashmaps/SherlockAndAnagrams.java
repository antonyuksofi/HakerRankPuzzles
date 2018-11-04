package puzzles.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {
    static int sherlockAndAnagrams(String str) {
        Map<Map<Character, Integer>, Integer> anagrams = new HashMap<>();

        for (int size = 1; size < str.length(); size++) {
            for (int position = 0; position + size <= str.length(); position++) {
                Map<Character, Integer> currentWord = new HashMap<>();
                String substr = str.substring(position, position + size);
                for (int i = 0; i < substr.length(); i++) {
                    char currentChar = substr.charAt(i);
                    currentWord.compute(currentChar, (ch, occurrences) -> occurrences == null ? 1 : occurrences + 1);
                }
                anagrams.compute(currentWord, (word, occurrences) -> occurrences == null ? 1 : occurrences + 1);
            }

        }

        int result = 0;
        for (Integer anagramOccurrences : anagrams.values()) {
            if (anagramOccurrences > 1) {
//                System.out.println(anagramOccurrences);
                if (anagramOccurrences == 2) {
                    result++;
                } else {
                    result += (anagramOccurrences * (anagramOccurrences - 1) / 2);
                }
            }
        }

        return result;
    }
}
