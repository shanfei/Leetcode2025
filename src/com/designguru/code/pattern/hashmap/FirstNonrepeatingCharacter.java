package com.designguru.code.pattern.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string, identify the position of the first character that appears only once in the string.
 * If no such character exists, return -1.
 *
 * Examples
 *
 * Example 1:
 *
 * Input: "apple"
 * Expected Output: 0
 * Justification: The first character 'a' appears only once in the string and is the first character.
 * Example 2:
 *
 * Input: "abcab"
 * Expected Output: 2
 * Justification: The first character that appears only once is 'c' and its position is 2.
 * Example 3:
 *
 * Input: "abab"
 * Expected Output: -1
 * Justification: There is no character in the string that appears only once.
 *
 *
 */
public class FirstNonrepeatingCharacter {

    public int firstUniqChar(String s) {

        Map<Character,Integer> m = new HashMap<>();

        char[] cs = s.toCharArray();

        for ( int i = 0; i < cs.length; i++ ) {
            char c = cs[i];
            int k = m.getOrDefault(c, i);
            if ( k == i ) {
                m.put(c, k);
            } else {
                m.remove(c);
            }
        }

        int min = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            min = Math.min(min, entry.getValue());
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
