package com.designguru.code.pattern.stack.monotonic;

/**
 *
 * Given an array of integers arr, return the sum of the minimum values from all possible contiguous subarrays within arr. Since the result can be very large, return the final sum modulo (109 + 7).
 *
 * Examples
 * Example 1:
 *
 * Input: arr = [3, 1, 2, 4, 5]
 * Expected Output: 30
 * Explanation:
 * The subarrays are: [3], [1], [2], [4], [5], [3,1], [1,2], [2,4], [4,5], [3,1,2], [1,2,4], [2,4,5], [3,1,2,4], [1, 2, 4, 5], [3, 1, 2, 4, 5].
 * The minimum values of these subarrays are: 3, 1, 2, 4, 5, 1, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 * Summing these minimums: 3 + 1 + 2 + 4 + 5 + 1 + 1 + 2 + 4 + 1 + 1 + 2 + 1 + 1 + 1 = 30.
 * Example 2:
 *
 * Input: arr = [2, 6, 5, 4]
 * Expected Output: 36
 * Explanation:
 * The subarrays are: [2], [6], [5], [4], [2,6], [6,5], [5,4], [2,6,5], [6,5,4], [2,6,5,4].
 * The minimum values of these subarrays are: 2, 6, 5, 4, 2, 5, 4, 2, 4, 2.
 * Summing these minimums: 2 + 6 + 5 + 4 + 2 + 5 + 4 + 2 + 4 + 2 = 36.
 * Example 3:
 *
 * Input: arr = [7, 3, 8]
 * Expected Output: 35
 * Explanation:
 * The subarrays are: [7], [3], [8], [7,3], [3,8], [7,3,8].
 * The minimum values of these subarrays are: 7, 3, 8, 3, 3, 3.
 * Summing these minimums: 7 + 3 + 8 + 3 + 3 + 3 = 27.
 *
 *
 */
public class SumOfSubArrayMin {

    public int sumSubarrayMins(int[] arr) {
        // ToDo: Write Your Code Here.

        return 0;
    }
}
