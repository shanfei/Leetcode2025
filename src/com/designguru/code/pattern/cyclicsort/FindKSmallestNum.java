package com.designguru.code.pattern.cyclicsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.
 *
 * Example 1:
 *
 * Input: [3, -1, 4, 5, 5], k=3
 * Output: [1, 2, 6]
 * Explanation: The smallest missing positive numbers are 1, 2 and 6.
 * Example 2:
 *
 * Input: [2, 3, 4], k=3
 * Output: [1, 5, 6]
 * Explanation: The smallest missing positive numbers are 1, 5 and 6.
 * Example 3:
 *
 * Input: [-2, -3, 4], k=2
 * Output: [1, 2]
 * Explanation: The smallest missing positive numbers are 1 and 2.
 *
 *
 */
public class FindKSmallestNum {

    public static List<Integer> findNumbers(int[] nums, int l) {

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> s = new HashSet<>();

        for ( int mn : nums ) {
            if (mn > 0) {
                s.add(mn);
            }
        }

        int j = 1;

        while (l > 0) {

            if (!s.contains(j)) {
                missingNumbers.add(j);
                l--;
            }

            j++;
        }

        return missingNumbers;
    }

}
