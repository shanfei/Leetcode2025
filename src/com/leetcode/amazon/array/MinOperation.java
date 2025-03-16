package com.leetcode.amazon.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * You are given an array nums consisting of positive integers.
 *
 * You can perform below two operations on the array multiple times:
 *
 * Select two elements with equal values and delete them from the array.
 * Select three elements with equal values and delete them from the array.
 * Return the minimum number of operations required to make the array empty, or -1 if it is not possible.
 *
 * Examples
 * Example 1:
 *
 * Input: nums = [1, 3, 2, 1, 2, 2, 3]
 *
 * Expected Output: 3
 * Justification: We can perform the following operations:
 * Remove the two 1s (one operation).
 * Remove the three 2s (second operation).
 * Remove the two 3s (third operation). Thus, the array can be emptied in 3 operations.
 * Example 2:
 *
 * Input: nums = [4, 4, 2, 5, 3, 2, 5, 3]
 * Expected Output: 4
 * Justification: We can perform operations such as removing pairs of 4, 2, 5, and 3 in successive steps, each taking one step. This results in the array being emptied in 4 operations.
 * Example 3:
 *
 * Input: nums = [7, 8, 7]
 * Expected Output: -1
 * Justification: It is not possible to make the array empty as we can't remove 8 by performing any of 2 operations.
 *
 *
 */
public class MinOperation {

    public static int minOperations(int[] nums) {

        Map<Integer, Integer> hm = new HashMap<>();

        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        int r = 0;

        for ( int count : hm.values() ) {

//            while ( value > 0 ) {

            if (count == 1) {
                return -1; // It's not possible to make the array empty
            }
            r += Math.ceil((double) count / 3);



//            }
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{7, 8, 7}));
    }
}
