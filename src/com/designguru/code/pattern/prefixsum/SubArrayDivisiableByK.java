package com.designguru.code.pattern.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Problem Statement
 * Given an array of integers nums and an integer k,
 * return the count of non-empty subarrays that have a sum that is divisible by k.
 *
 * A subarray is a continuous part of an array.
 *
 * Examples
 * Example 1
 * Input: nums = [3, 1, 2, -2, 5, -1], k = 3
 * Expected Output: 7
 * Justification: The subarrays that sum to a multiple of 3 are [3], [1, 2], [3, 1, 2], [3, 1, 2, -2, 5], [1, 2, -2, 5], [-2, 5], and [2, -2].
 * Example 2
 * Input: nums = [4, 5, 0, -2, -3, 1], k = 5
 * Expected Output: 7
 * Justification: The subarrays that sum to a multiple of 5 are [5], [4, 5, 0, -2, -3, 1], [5, 0], [0], [5, 0, -2, -3], [0, -2, -3], and [-2, -3].
 * Example 3
 * Input: nums = [-1, 2, 9], k = 2
 * Expected Output: 2
 * Justification: The subarrays that sum to a multiple of 2 are [2] and [-1, 2, 9].
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * 2 <= k <= 104
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * nums[i] is either 0 or 1.
 * 0 <= goal <= nums.length
 *
 */
public class SubArrayDivisiableByK {

    public static int subarraysDivByK(int[] nums, int k) {

        int prefixSum = 0;

        Map<Integer, Integer> remainderCountMap = new HashMap<>();

        remainderCountMap.put(0,1);

        int count = 0;

        for ( int n : nums ) {
            prefixSum += n;

            int r = prefixSum % k;

            if (r < 0) r += k;

            int remainedCount = remainderCountMap.getOrDefault(r, 0);

            count += remainedCount;

            remainderCountMap.put(r, remainedCount + 1);
        }


        return count;
    }

    public static void main(String[] args) {
       System.out.println( subarraysDivByK( new int[] {3, 1, 2, -2, 5, -1}, 3) );
        System.out.println( subarraysDivByK( new int[] {4, 5, 0, -2, -3, 1}, 5) );
        System.out.println( subarraysDivByK( new int[] {-1, 2, 9}, 2) );
    }
}
