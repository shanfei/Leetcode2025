package com.designguru.code.pattern.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class MaximunSizeSubarraySumEqualsK {


    /**
     *
     * Given an array of integers nums and an integer k, find the length of the longest subarray that sums to k.
     * If no such subarray exists, return 0.
     *
     * Examples
     * Example 1:
     *
     * Input: nums = [1, 2, 3, -2, 5], k = 5
     * Output: 2
     * Explanation: The longest subarray with a sum of 5 is [2, 3], which has a length of 2.
     * Example 2:
     *
     * Input: nums = [-2, -1, 2, 1], k = 1
     * Output: 2
     * Explanation: The longest subarray with a sum of 1 is [-1, 2], which has a length of 2.
     * Example 3:
     *
     * Input: nums = [3, 4, 7, 2, -3, 1, 4, 2], k = 7
     * Output: 4
     * Explanation: The longest subarray with a sum of 7 is [7, 2, -3, 1], which has a length of 4.
     * Constraints:
     *
     * 1 <= nums.length <= 2 * 105
     * -104 <= nums[i] <= 104
     * -109 <= k <= 109
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxSubArrayLen(int[] nums, int k) {

        int culSum = 0;

        int maxLength = 0;

        Map<Integer, Integer> culSumMap = new HashMap<>();

        for ( int i = 0; i < nums.length; ++i ) {

            culSum += nums[i];

            if ( culSum == k ) {
                maxLength = Math.max( maxLength, i + 1 );
            } else {
                int ci = culSum - k;
                Integer index = culSumMap.get(ci);
                if (  index != null ) {
                    maxLength = Math.max( maxLength, i - index  ) ;
                }
            }

            culSumMap.put(culSum, i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayLen(new int[] { 1, 2, 3, -2, 5}, 5));
        System.out.println(maxSubArrayLen(new int[] { -2, -1, 2, 1 }, 1));
        System.out.println(maxSubArrayLen(new int[] { 3, 4, 7, 2, -3, 1, 4, 2 }, 7));

    }
}
