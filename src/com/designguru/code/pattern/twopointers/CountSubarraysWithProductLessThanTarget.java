package com.designguru.code.pattern.twopointers;

/**
 *
 * Given an array nums with positive numbers and a positive integer target,
 * return the count of contiguous subarrays whose product is less than the target number.
 *
 * Examples
 * Example 1:
 * Input: nums = [2, 5, 3, 10], target=30
 * Output: 6
 * Explanation: There are six contiguous subarrays ([2], [5], [2, 5], [3], [5, 3], [10]) whose product is less than the target.
 *
 * Example 2:
 * Input: nums = [8, 2, 6, 5], target=50
 * Output: 7
 * Explanation: There are seven contiguous subarrays ([8], [2], [8, 2], [6], [2, 6], [5], [6, 5]) whose product is less than the target.
 *
 * Example 3:
 * Input: nums = [10, 5, 2, 6], k = 0
 * Expected Output: 0
 * Explanation: Subarrays with product less than 0 doesn't exists.
 *
 */
public class CountSubarraysWithProductLessThanTarget {

    public static int findSubarrays(int[] nums, int target) {

        if (target == 0) return 0;

        int totalCount = 0;

        int m = 0, n = 0;

        int product = 1;

        while ( n < nums.length ) {

            product *= nums[n];

            while (m < nums.length &&  product >= target ) {
                product /= nums[m++];
            }

            if ( m > n ) {
                return totalCount;
            }

            totalCount += n - m + 1;

            n++;
        }


        return totalCount;
    }

    public static void main(String[] args) {

        int[][] p = {
                {2, 5, 3, 10},
                {8, 2, 6, 5},
                {10, 5, 2, 6}
        };

        int[] t = {
            30, 50, 0
        };

        for (int i = 0; i < p.length; ++i) {
            System.out.println(findSubarrays(p[i], t[i]));
        }
    }

}
