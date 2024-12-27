package com.designguru.code.pattern.slidewindow;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string and a pattern,
 * find the smallest substring in the given string which has all the character occurrences of the given pattern.
 *
 * Example 1:
 *
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 * Example 2:
 *
 * Input: String="aabdec", Pattern="abac"
 * Output: "aabdec"
 * Explanation: The smallest substring having all characters occurrences of the pattern is "aabdec"
 * Example 3:
 *
 * Input: String="abdbca", Pattern="abc"
 * Output: "bca"
 * Explanation: The smallest substring having all characters of the pattern is "bca".
 * Example 4:
 *
 * Input: String="adcad", Pattern="abc"
 * Output: ""
 * Explanation: No substring in the given string has all characters of the pattern
 *
 */
public class SmallestWindowContainsSubstring {

    public String findSubstring(String str, String pattern) {
        String result = "";

        Map<Character, Integer> map = patternMap(pattern);

        int minSubstringLength = Integer.MAX_VALUE;


        for (int s = 0; s < str.length(); ++s) {

            char c = str.charAt(s);

            Integer countOfC = map.get(c);

            if (countOfC != null) {

                int foundCount = map.size();

                Map<Character, Integer> m = new HashMap<>();

                int e = s;

                while ( e < str.length() ) {

                    char ec = str.charAt(e);

                    if ( m.getOrDefault(ec, 0) < map.getOrDefault(ec, -1) ) {
                        m.put(ec, m.getOrDefault(ec, 0) + 1);
                        if ( m.get(ec).equals(map.get(ec)) ) {
                            foundCount--;
                        }
                    }

                    if (foundCount == 0) {
                        if ( e - s + 1 < minSubstringLength ) {
                            minSubstringLength = e - s + 1;
                            result = str.substring(s, e + 1);
                        }
                    }

                    e++;
                }
            }
        }

        return result;
    }

    Map<Character, Integer> patternMap(String pattern) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;

    }


}
