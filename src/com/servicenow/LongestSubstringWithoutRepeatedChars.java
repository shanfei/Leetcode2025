package com.servicenow;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * Leetcode 3
 *
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * slide window
 */
public class LongestSubstringWithoutRepeatedChars {

    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> sc = new HashMap<>();

        int maxLength = 0;

        int i = 0, j = 0;

        while ( j < s.length() ) {

            if ( sc.containsKey(s.charAt(j)) ) {
                i = Math.max(i, sc.get(s.charAt(j)));
            }

            maxLength = Math.max( maxLength, j - i + 1);

            sc.put(s.charAt(j), ++j);
        }

        return maxLength;


    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatedChars instance = new LongestSubstringWithoutRepeatedChars();

        String[] s = {"abcabcbb", "aab" , "bbbbb", "", " ", "pwwkew"};

        for (String i : s) {
            System.out.println(instance.lengthOfLongestSubstring(i));
        }
    }
}
