package challenges;

import java.util.HashMap;

public class LongestSubstring {

    private static final HashMap<Character, Integer> LETTERS_MAP = new HashMap<>();

    public static void main(String[] args) {

        // System.out.println(lengthOfLongestSubstring("mmmmm"));
        // System.out.println(lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(lengthOfLongestSubstring("pwwkew"));
        // System.out.println(lengthOfLongestSubstring("aab"));
        // System.out.println(lengthOfLongestSubstring("dvdf"));
        // System.out.println(lengthOfLongestSubstring("abccdar"));
        System.out.println(lengthOfLongestSubstring(""));


        System.out.println("==============================================");

        // System.out.println(lengthOfLongestSubstringV2("mmmmm"));
        // System.out.println(lengthOfLongestSubstringV2("abcabcbb"));
        // System.out.println(lengthOfLongestSubstringV2("pwwkew"));
        // System.out.println(lengthOfLongestSubstringV2(""));
        // System.out.println(lengthOfLongestSubstringV2("aab"));
        // System.out.println(lengthOfLongestSubstringV2("dvdf"));
        // System.out.println(lengthOfLongestSubstringV2("abccdar"));

    }

    private static int lengthOfLongestSubstring(String s) {
        // LETTERS_MAP.clear();

        int longestSubstring = 0;

        for (int i = 0; i < s.length(); i++) {

            if (!LETTERS_MAP.containsKey(s.charAt(i))) {
                LETTERS_MAP.put(s.charAt(i), i);

            } else {
                i = LETTERS_MAP.get(s.charAt(i));
                if (LETTERS_MAP.size() > longestSubstring) {
                    longestSubstring = LETTERS_MAP.size();
                }
                LETTERS_MAP.clear();
            }
        }

        return Math.max(LETTERS_MAP.size(), longestSubstring);
    }

    private static int lengthOfLongestSubstringV2(String s) {
        int startPointer = 0;
        int currentPointer = 1;
        int distance = 0;

        while (currentPointer < s.length()) {
            if (s.charAt(startPointer) == s.charAt(currentPointer)) {
                if ((currentPointer - startPointer) > distance ) {
                    distance = currentPointer - startPointer;
                }
                if (currentPointer == startPointer + 1) {
                    startPointer++;
                    currentPointer++;
                    continue;
                }
                startPointer = currentPointer - 1;
                continue;

            }
            currentPointer ++;
        }
        return Math.max((currentPointer - startPointer), distance);
    }

}
