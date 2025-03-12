package com.meta.binarysearch;

/**
 *
 *
 * Problem Statement
 * Given an array arr containing unique integers in the ascending order, and integer k,
 * return the kth missing number starting from the arr[0].
 *
 * The missing numbers are those that are not present in the array, and greater than arr[0].
 *
 * Examples
 * Example 1:
 *
 * Input: arr = [3, 5, 6, 7], k = 2
 * Expected Output: 8
 * Justification: The missing numbers in sequence are 4 and 8. The 2nd missing number is 8.
 * Example 2:
 *
 * Input: arr = [1, 2, 4, 8], k = 3
 * Expected Output: 6
 * Justification: The missing numbers are 3, 5, 6, etc. The 3rd missing number is 6.
 * Example 3:
 *
 * Input: arr = [2, 3, 4, 7, 8, 10, 11], k = 2
 * Expected Output: 6
 * Justification: The missing numbers in this sequence start from 5, 6, 9... The 2nd missing number in this sequence is 6.
 *
 *
 */
public class MissingElemInSortedArray {

    // Method to find the k-th missing element in a sorted array
    public int findMissingElement(int[] nums, int k) {

        int n = nums.length;

        int s = 0, e = n - 1;

        while ( s < e ) {

            int m = ( s + e ) / 2;

            // move tot the right side
            if ( nums[m]  - nums[0] - m < k ) {
                s = m;
            } else {
                e = m - 1;
            }

        }

        return e + nums[0] + k;
    }
}
