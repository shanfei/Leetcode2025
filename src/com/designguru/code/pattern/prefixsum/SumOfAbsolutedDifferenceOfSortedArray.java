package com.designguru.code.pattern.prefixsum;


/**
 *
 * Problem Statement
 * Given an integer array nums sorted in increasing order,
 * return an array result of the same length, where result[i]
 * should be the sum of the absolute differences between nums[i] and every other element in nums.
 *
 * Examples
 * Example 1
 * Input: [1, 3, 6]
 * Output: [7, 5, 8]
 * Explanation:
 * For result[0]: |1-3| + |1-6| = 2 + 5 = 7
 * For result[1]: |3-1| + |3-6| = 2 + 3 = 5
 * For result[2]: |6-1| + |6-3| = 5 + 3 = 8
 * Example 2
 * Input: [2, 4, 7]
 * Output: [7, 5, 8]
 * Explanation:
 * For result[0]: |2-4| + |2-7| = 2 + 5 = 7
 * For result[1]: |4-2| + |4-7| = 2 + 3 = 5
 * For result[2]: |7-2| + |7-4| = 5 + 3 = 8
 * Example 3
 * Input: [1, 2, 4, 5]
 * Output: [8, 6, 6, 6]
 * Explanation:
 * For result[0]: |1-2| + |1-4| + |1-5| = 1 + 3 + 4 = 8
 * For result[1]: |2-1| + |2-4| + |2-5| = 1 + 2 + 3 = 6
 * For result[2]: |4-1| + |4-2| + |4-5| = 3 + 2 + 1 = 6
 * For result[3]: |5-1| + |5-2| + |5-4| = 4 + 3 + 1 = 8
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= nums[i + 1] <= 104
 *
 */
public class SumOfAbsolutedDifferenceOfSortedArray {

    public static int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int[] prefixSum = new int[n + 1];

        for ( int i = 0; i < n; ++i ) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        //formula
        for ( int i = 0; i < n; ++i ) {
            int leftSum = prefixSum[i];
            int rightSum = prefixSum[n] - prefixSum[i + 1];
            result[i] = ( i * nums[i] - leftSum ) +  (  rightSum - ( n - i - 1 ) * nums[i] );
        }

        return result;
    }

    public static void main(String[] args) {

        int[] r = getSumAbsoluteDifferences(new int[] { 1, 3, 6 });
        for ( int i : r ) {
            System.out.println(i);
        }
        System.out.println("=====================");


    }
}
