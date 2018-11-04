package puzzles.stringmanipulation;

import java.util.*;

public class Anagrams {

    static int getAmountOfSymbolsToDeleteToMakeAnagram(String firstStr, String secondStr) {
        Map<Character, Integer> firstStrChars = getCharsMapOfString(firstStr);
        Map<Character, Integer> secondStrChars = getCharsMapOfString(secondStr);

        return subtractCharMaps(firstStrChars, secondStrChars) + subtractCharMaps(secondStrChars, firstStrChars);
    }

    static int subtractCharMaps(Map<Character, Integer> first, Map<Character, Integer> second) {
        int result = 0;
        for (Map.Entry<Character, Integer> entry : first.entrySet()) {
            Integer occurrencesInFirst = entry.getValue();
            Integer occurrencesInSecond = second.get(entry.getKey());
            if (occurrencesInSecond == null) {
                result += occurrencesInFirst;
            } else if (occurrencesInFirst > occurrencesInSecond) {
                result += occurrencesInFirst - occurrencesInSecond;
            }
        }
        return result;
    }

    static Map<Character, Integer> getCharsMapOfString(String str) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            Integer occurences = chars.get(currentChar);
            if (occurences != null) {
                chars.put(currentChar, occurences + 1);
            } else {
                chars.put(currentChar, 1);
            }
        }
        return chars;
    }
}
