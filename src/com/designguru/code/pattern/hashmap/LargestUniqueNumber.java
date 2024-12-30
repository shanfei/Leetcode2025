package com.designguru.code.pattern.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers, identify the highest value that appears only once in the array. If no such number exists, return -1.
 *
 * Examples:
 *
 * Example 1:
 *
 * Input: [5, 7, 3, 7, 5, 8]
 * Expected Output: 8
 * Justification: The number 8 is the highest value that appears only once in the array.
 * Example 2:
 *
 * Input: [1, 2, 3, 2, 1, 4, 4]
 * Expected Output: 3
 * Justification: The number 3 is the highest value that appears only once in the array.
 * Example 3:
 *
 * Input: [9, 9, 8, 8, 7, 7]
 * Expected Output: -1
 * Justification: There is no number in the array that appears only once.
 *
 */
public class LargestUniqueNumber {

    public int largestUniqueNumber(int[] a) {
        int maxUnique = -1;

        Map<Integer,Integer> m = new HashMap<>();

        for ( int i = 0; i < a.length; i++ ) {
            int c = a[i];
            int k = m.getOrDefault(c, 0) + 1;
            m.put(c, k);
        }

        for ( Map.Entry<Integer,Integer> entry : m.entrySet()) {
            if (entry.getValue() == 1) {
                maxUnique = Math.max(maxUnique, entry.getKey());
            }
        }

        return maxUnique;
    }


}
