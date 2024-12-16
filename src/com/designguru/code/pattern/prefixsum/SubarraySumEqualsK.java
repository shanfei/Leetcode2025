package com.designguru.code.pattern.prefixsum;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * Problem Statement
 * Given an array nums containing n integers and integer k, return the total number of subarrays having sum equal to k.
 *
 * A subarray is defined as a contiguous non-empty sequence of the array elements.
 *
 * Examples
 * Example 1:
 *
 * Input: nums = [1, 2, 3], k = 3
 * Expected Output: 2
 * Justification: There are two subarrays that sum to 3: [1, 2] and [3].
 * Example 2:
 *
 * Input: nums = [10, 2, -2, -20, 10], k = -10
 * Expected Output: 3
 * Justification: Three subarrays sum up to -10: [10, 2, -2, -20], [2, -2, -20, 10], and [-20, 10].
 * Example 3:
 *
 * Input: nums = [5, 1, 2, -3, 4, -2], k = 3
 * Expected Output: 2
 * Justification: There are two subarrays that sum to 3: [2, -3, 4], and [1, 2].
 *
 */
public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {


        int count = 0;

        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);

        int prefixSum = 0;

        for (int n : nums) {

            prefixSum += n;

            count += m.getOrDefault(prefixSum - k, 0);

            m.put(prefixSum, m.getOrDefault(prefixSum, 0) + 1);

        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] { 1, 2, 3 }, 3));
        System.out.println(subarraySum(new int[] { 10, 2, -2, -20, 10 }, -10));
        System.out.println(subarraySum(new int[] { 5, 1, 2, -3, 4, -2 }, 3));
    }
}
