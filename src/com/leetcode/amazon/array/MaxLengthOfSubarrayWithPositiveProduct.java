package com.leetcode.amazon.array;

/**
 *
 * Given an integer array nums, find the maximum length of a subarray where the product of all its elements is greater than 0.
 *
 * A subarray is a sequence of consecutive elements from the original array.
 *
 * Examples
 *
 * Example 1:
 *
 * Input: nums = [1, -2, 3, 4]
 * Expected Output: 2
 * Justification: The longest subarray with a positive product is [3, 4], with a length of 2.
 *
 * Example 2:
 *
 * Input: nums = [-1, -2, -3, -4]
 * Expected Output: 4
 * Justification: The entire array produces a positive product since an even number of negative numbers multiply to a positive product.
 * Hence, the longest length is 4.
 *
 * Example 3:
 *
 * Input: nums = [0, -1, 2, -3, 4, -5, 6]
 * Expected Output: 5
 * Justification: The longest subarray with a positive product is [2, -3, 4, -5, 6], with a length of 5.
 *
 *
 */
public class MaxLengthOfSubarrayWithPositiveProduct {

    public int getMaxLen(int[] nums) {

        int maxLength = -1;

        int pc = 0, nc = 0;

        for ( int i = 0; i < nums.length;  ++i ) {

            int k = nums[i];

            if ( k == 0 ) {
                pc = 0;
                nc = 0;
            } else if ( k > 0 ) {
                pc++;
                nc = nc == 0 ? 0 : nc + 1;
            } else {
                int t = pc;
                pc =  ( nc == 0 ) ? 0 : nc + 1;
                nc = t + 1;
            }

            maxLength = Math.max(maxLength, pc);

        }


        return maxLength;
    }
}
