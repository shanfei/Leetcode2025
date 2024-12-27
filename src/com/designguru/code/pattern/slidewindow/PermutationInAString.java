package com.designguru.code.pattern.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {

    /**
     *
     * Given a string and a pattern, find out if the string contains any permutation of the pattern.
     *
     * Permutation is defined as the re-arranging of the characters of the string.
     * For example, “abc” has the following six permutations:
     *
     * abc
     * acb
     * bac
     * bca
     * cab
     * cba
     * If a string has ‘n’ distinct characters, it will have n! permutations.
     *
     * Example 1:
     *
     * Input: str="oidbcaf", pattern="abc"
     * Output: true
     * Explanation: The string contains "bca" which is a permutation of the given pattern.
     * Example 2:
     *
     * Input: str="odicf", pattern="dc"
     * Output: false
     * Explanation: No permutation of the pattern is present in the given string as a substring.
     * Example 3:
     *
     * Input: str="bcdxabcdy", pattern="bcdyabcdx"
     * Output: true
     * Explanation: Both the string and the pattern are a permutation of each other.
     * Example 4:
     *
     * Input: str="aaacb", pattern="abc"
     * Output: true
     * Explanation: The string contains "acb" which is a permutation of the given pattern.
     *
     * @param str
     * @param pattern
     *
     * @return
     *
     */
    public boolean findPermutation(String str, String pattern) {

        Map<Character, Integer> map = patternMap(pattern);

        int e = 0;

        for (int s = 0; s < str.length(); ++s) {

            char c = str.charAt(s);

            Integer countOfC = map.get(c);

            if (countOfC != null) {

                int foundCount = map.size();

                Map<Character, Integer> m = new HashMap<>();

                e = s;

                while ( e < str.length() ) {

                    char ec = str.charAt(e);

                    if (!map.containsKey(ec) || m.getOrDefault(ec, 0) + 1 > map.get(ec)) break;

                    m.put(ec, m.getOrDefault(ec, 0) + 1);

                    if (m.get(ec).equals(map.get(ec))) {
                        foundCount--;
                    }

                    if (foundCount == 0) {
                        return true;
                    }

                    e++;
                }
            }
        }

        return false;
    }

    Map<Character, Integer> patternMap(String pattern) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;

    }
}
