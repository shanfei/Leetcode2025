package com.designguru.code.pattern.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string, determine the maximum number of times the word "balloon" can be formed using the characters from the string.
 * Each character in the string can be used only once.
 *
 * Examples:
 *
 * Example 1:
 *
 * Input: "balloonballoon"
 * Expected Output: 2
 * Justification: The word "balloon" can be formed twice from the given string.
 *
 * Example 2:
 *
 * Input: "bbaall"
 * Expected Output: 0
 * Justification: The word "balloon" cannot be formed from the given string as we are missing the character 'o' twice.
 *
 * Example 3:
 *
 * Input: "balloonballoooon"
 * Expected Output: 2
 * Justification: The word "balloon" can be formed twice, even though there are extra 'o' characters.
 *
 *
 */
public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {

        String s = "balloon";

        Map<Character,Integer> ms = new HashMap<>();

        for (char c : s.toCharArray()) {
            ms.put(c, ms.getOrDefault(c, 0) + 1);
        }

        Map<Character,Integer> m = new HashMap<>();

        char[] cs = text.toCharArray();

        for (char c : cs) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        int l = 0;

        for (Map.Entry<Character,Integer> entry : ms.entrySet()) {
            char key = entry.getKey();
            Integer value = m.get(key);

            if ( value == null   || value / entry.getValue() < 1 ) {
                return 0;
            } else {
                if ( l == 0 ) {
                    l = value / entry.getValue();
                } else {
                    l =  Math.min(l, value / entry.getValue());
                }
            }
        }


        return l;
    }
}
