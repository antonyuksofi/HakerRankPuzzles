package puzzles.hashmaps;

import java.util.HashSet;

public class TwoStringsCommonSubstring {

    public static final String YES_RESPONSE = "YES";
    public static final String NO_RESPONSE = "NO";

    static String twoStrings(String s1, String s2) {

        HashSet<Character> s1Symbols = new HashSet<>();
        for (int i = 0; i < s1.length(); i++)
            s1Symbols.add(s1.charAt(i));

        HashSet<Character> s2Symbols = new HashSet<>();
        for (int i = 0; i < s2.length(); i++)
            s2Symbols.add(s2.charAt(i));

        int s1SymbolsInitialSize = s1Symbols.size();
        s1Symbols.addAll(s2Symbols);
        if (s1Symbols.size() < s1SymbolsInitialSize + s2Symbols.size()) {
            return YES_RESPONSE;
        }

        return NO_RESPONSE;
    }
}
