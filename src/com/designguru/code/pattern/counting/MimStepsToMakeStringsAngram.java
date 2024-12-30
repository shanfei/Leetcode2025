package com.designguru.code.pattern.counting;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two strings, s and t, of the same length, return the minimum number of steps required to make t an anagram of s.
 *
 * In each step, you can replace any character in t with another character.
 *
 * An anagram of a string is a string that contains the same characters in any order.
 *
 * Examples
 * Example 1:
 *
 * Input: s = "designgurus", t = "garumdespgn"
 * Expected Output: 3
 * Justification: We need to replace a, m, and p characters in the string t to match the frequency of characters in s.
 * Example 2:
 *
 * Input: s = "abc", t = "def"
 * Expected Output: 3
 * Justification: We need to replace all three characters in t to match those in s.
 * Example 3:
 *
 * Input: s = "listen", t = "silent"
 * Expected Output: 0
 * Justification: The string t is already an anagram of s.
 *
 */
public class MimStepsToMakeStringsAngram {

    public int calculateSteps(String s, String t) {

        Map<Character, Integer> fMapS = new HashMap<>();

        Map<Character, Integer> fMapt = new HashMap<>();


        return 0;
    }


}
