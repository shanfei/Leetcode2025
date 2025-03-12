package com.meta.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Problem Statement
 * Given an array nums containing only 1 and 0 digits,
 * return the maximum length of the contiguous subarray having an equal number of 1 and 0.
 *
 * Examples
 * Example 1:
 * Input: [0, 1]
 * Expected Output: 2
 * Justification: The longest subarray with equal numbers of 0s and 1s is [0, 1].
 *
 * Example 2:
 * Input: [1, 1, 0, 0, 1, 1, 0]
 * Expected Output: 6
 * Justification: The subarray [1, 0, 0, 1, 1, 0] contains three 0s and three 1s.
 *
 * Example 3:
 * Input: [0, 1, 1, 0, 1, 0, 0, 1, 1]`
 * Expected Output: 8
 * Justification: The subarray from the first to the eighth element is the longest with an equal number of 0s and 1s.
 *
 *
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);

        int s = 0;
        int d = 0;

        for ( int i = 0; i < nums.length; ++i ) {

            int n = nums[i];

            s += ( n == 0 ) ? -1 : 1 ;

            if ( m.containsKey(s) ) {
                d = Math.max( d, i - m.get(s) );
            } else {
                m.put( s, i );
            }

        }

        return d;
    }
}
