package com.designguru.code.pattern.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given two strings, one representing a ransom note and the other representing the available letters from a magazine,
 * determine if it's possible to construct the ransom note using only the letters from the magazine.
 * Each letter from the magazine can be used only once.
 *
 * Examples:
 *
 * Example 1:
 *
 * Input: Ransom Note = "hello", Magazine = "hellworld"
 * Expected Output: true
 * Justification: The word "hello" can be constructed from the letters in "hellworld".
 * Example 2:
 *
 * Input: Ransom Note = "notes", Magazine = "stoned"
 * Expected Output: true
 * Justification: The word "notes" can be fully constructed from "stoned" from its first 5 letters.
 * Example 3:
 *
 * Input: Ransom Note = "apple", Magazine = "pale"
 * Expected Output: false
 * Justification: The word "apple" cannot be constructed from "pale" as we are missing one 'p'.
 *
 */
public class RansomNotes {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mr = new HashMap<>();
        Map<Character, Integer> mm = new HashMap<>();

        for ( char c : ransomNote.toCharArray() ) {

            mr.put(c, mr.getOrDefault(c, 0) + 1);
        }

        for ( char c : magazine.toCharArray() ) {

            mm.put(c, mm.getOrDefault(c, 0) + 1);
        }

        for ( Map.Entry<Character, Integer> entry : mr.entrySet() ) {

            char key = entry.getKey();

            Integer value = mr.get(key);

            Integer maxValue = mm.getOrDefault(key, 0);

            if (value > maxValue) {
                return false;
            }

        }


        return true;
    }


}
