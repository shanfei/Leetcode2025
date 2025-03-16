package com.leetcode.amazon.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array nums containing the positive integers,
 *
 * remove the smallest subarray (maybe empty) from nums such that the sum of the remaining elements is divisible by p.
 * You are not allowed to remove the whole array.
 *
 * Return the length of the smallest subarray that you need to remove, or -1 if it's not possible.
 *
 * A subarray is a contiguous sequence of elements in the array.
 *
 * Examples
 *
 * Example 1:
 *
 * Input: nums = [5, 9, 7, 8], P = 5
 * Expected Output: 1
 * Justification: Removing the subarray [9] results in a new array [5, 7, 8] whose sum is 20, which is divisible by 5.
 *
 * Example 2:
 *
 * Input: nums = [6, 4, 3, 2, 7, 6, 2], P = 10
 * Expected Output: 0
 * Justification: We don't need to remove any element from the array, as the sum of all array elements is divisible by 10.
 *
 * Example 3:
 *
 * Input: nums = [8, 19, 4, 3], P = 10
 * Expected Output: 1
 * Justification: By removing the subarray [4], we get a new array [8, 19, 3] with a sum of 30, Which is divisible by 10.
 *
 *
 */
public class MakeSumDivisibleByP {

    // Method to find the minimum subarray length to remove for making the sum divisible by P
    public int minSubarray(int[] nums, int P) {

        int totalSum = 0;

        for ( int n : nums ) {
            totalSum += n;
        }

        totalSum = totalSum % P;

        if ( totalSum == 0 ) return 0;

        Map<Integer, Integer> prefixRemainerMap = new HashMap<>();
        prefixRemainerMap.put(0 , -1);

        int currSum = 0;
        int minL = Integer.MAX_VALUE;

        for ( int i = 0; i < nums.length; i++ ) {

            // currSum is the remainder of prefix sum from [0, i - 1]
            currSum = ( currSum + nums[i] ) % P;

            int complement = ( currSum - totalSum + P ) % P;

            if (prefixRemainerMap.containsKey(complement)) {
                minL = Math.min(minL, i - prefixRemainerMap.get(complement));
            }

            prefixRemainerMap.put(currSum, i);
        }

        return minL == Integer.MAX_VALUE || minL == nums.length ? -1 : minL;
    }


}
