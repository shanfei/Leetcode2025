package com.designguru.code.pattern.twopointers;

/**
 *
 * Problem Statement
 * Given an array of sorted numbers, move all non-duplicate number instances at the beginning of the array in-place.
 * The non-duplicate numbers should be sorted and you should not use any extra space so that the solution has constant space complexity i.e., .
 *
 * Move all the unique number instances at the beginning of the array and after moving return the length of the subarray that has no duplicate in it.
 *
 * Example 1:
 *
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after moving element will be [2, 3, 6, 9].
 * Example 2:
 *
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after moving elements will be [2, 11].
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 *
 */
public class FindNonDuplicatedNumbers {

    public int findNonDuplicatedNumbers(int[] arr) {
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                count++;
            }
        }

        return count;
    }
}
