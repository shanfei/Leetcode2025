package com.leetcode.amazon.array;


/**
 *
 * Given an integer array nums, return the minimum swaps required to make nums a valid array.
 *
 * You can swap any two adjacent elements of the array.
 *
 * An array is a valid array if it meets the following conditions:
 *
 * The largest element is at the rightmost position in the array.
 * The smallest element is at the leftmost position in the array.
 *
 * If there are multiple smallest and largest elements,
 * any of the smallest elements should be at the leftmost position and any of the largest should be at the rightmost position.
 *
 * Examples
 * Example 1:
 *
 * Input: [3, 1, 2]
 * Expected Output: 2
 * Justification: The first swap moves 3 to the second position by swapping with 1,
 * and the second swap moves 3 to the third position by swapping with 2, positioning the smallest element (1) at the beginning and the largest element (3) at the end.
 *
 * Example 2:
 *
 * Input: [1, 2, 3, 4]
 * Expected Output: 0
 * Justification: This array already meets the criteria with the smallest element (1) at the start and the largest element (4) at the end,
 * requiring no swaps.
 *
 * Example 3:
 *
 * Input: [3, 5, 4, 5, 1, 2]
 * Expected Output: 5
 * Justification: The smallest element (1) requires 4 swaps to move to the beginning, and after that the largest element (5) requires 1 swap to move to the rightmost position, considering the optimal path that minimizes overall swaps.
 *
 *
 */
public class MinAdjSwapToMakeValidArray {

    // Function to find the minimum number of swaps required
    // to sort the given array in non-decreasing order

    public static int minSwaps(int[] nums) {

        int maxPos = -1, minPos = -1;
        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;

        for ( int i = 0; i < nums.length; ++i ) {

            int n = nums[i];

            maxValue = Math.max(maxValue, n);
            if (maxValue == n) {
                maxPos = i;
            }

            minValue = Math.min(minValue, n);
            if (minValue == n) {
                minPos = i;
            }
        }


        int maxT = nums.length - 1 - maxPos;
        int minT = minPos;

        int r = maxT + minT;

        if ( minPos > maxPos ) {
            r += 1;
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(MinAdjSwapToMakeValidArray.minSwaps(new int[] {3, 5, 4, 5, 1, 2}));
    }
}
