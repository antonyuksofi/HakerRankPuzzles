package puzzles.hashmaps;

import java.util.HashMap;

public class RansomNote {

    static String checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> wordsInMagazine = new HashMap<>();
        for (String word : magazine) {
            wordsInMagazine.computeIfPresent(word, (keyWord, amount) -> amount + 1);
            wordsInMagazine.computeIfAbsent(word, amount -> 1);
        }

        for (String word : note) {
            if (wordsInMagazine.containsKey(word)) {
                wordsInMagazine.computeIfPresent(word, (keyWord, amount) -> amount - 1);
                if (wordsInMagazine.get(word).equals(0)) {
                    wordsInMagazine.remove(word);
                }
            }
            else {
                return "No";
            }
        }

        return "Yes";
    }
}
