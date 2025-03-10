package com.meta.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an integer array nums and an integer k,
 * return true if nums has a good subarray or false otherwise.
 *
 * A good subarray is a subarray where:
 *
 * its length is at least two, and
 * the sum of the elements of the subarray is a multiple of k.
 * Note that:
 *
 * A subarray is a contiguous part of the array.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 *
 * Example 1:
 *
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 *
 * Example 2:
 *
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 *
 * Example 3:
 *
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 *
 *
 */
public class CheckSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        int[] prefixSumArray = calculatePrefixSumArray(nums);

        // the 1st position of prefix mod
        Map<Integer, Integer> modSeen = new HashMap<>();

        for ( int i = 0; i < nums.length; ++i ) {

            int prefixMod = prefixSumArray[i + 1] % k;

            if ( i - modSeen.get(prefixMod) > 1 ) {
                return true;
            } else {
                modSeen.put(prefixMod, i);
            }
        }

        return false;
    }

    int[] calculatePrefixSumArray(int[] nums) {

        int[] prefixSumArray = new int[nums.length + 1];

        int prefixSum = 0;

        // calculate the prefix sum of the array
        for ( int i = 1; i < prefixSumArray.length; ++i ) {
            prefixSumArray[i] = prefixSum + prefixSumArray[i - 1];
            prefixSum += nums[i - 1];
        }

        return prefixSumArray;
    }
}
