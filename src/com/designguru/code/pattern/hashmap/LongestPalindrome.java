package com.designguru.code.pattern.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string, determine the length of the longest palindrome that can be constructed using the characters from the string.
 * You don't need to return the palindrome itself,
 * just its maximum possible length.
 *
 * Examples:
 *
 * Input: "applepie"
 * Expected Output: 5
 * Justification: The longest palindrome that can be constructed from the string is "pepep",
 * which has a length of 5. There are are other palindromes too but they all will be of length 5.
 *
 * Input: "aabbcc"
 * Expected Output: 6
 * Justification: We can form the palindrome "abccba" using the characters from the string, which has a length of 6.
 *
 * Input: "bananas"
 * Expected Output: 5
 * Justification: The longest palindrome that can be constructed from the string is "anana", which has a length of 5.
 *
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {

        int length = 0;

        Map<Character,Integer> m = new HashMap<>();

        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        int maxOddCount = 0;

        for (Map.Entry<Character,Integer> entry : m.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                length += entry.getValue();
            } else {
                maxOddCount = Math.max(maxOddCount, entry.getValue());
            }
        }


        int count = 0;

        for (Map.Entry<Character,Integer> entry : m.entrySet()) {
            if (entry.getValue() % 2 != 0 ) {
                if ( maxOddCount != 0 && ( entry.getValue() != maxOddCount || count > 0 ) ) {
                    length += entry.getValue() - 1;
                } else if ( maxOddCount != 0  && count == 0 ) {
                    count++;
                    length += maxOddCount;
                }
            }
        }


        return length;
    }



}
