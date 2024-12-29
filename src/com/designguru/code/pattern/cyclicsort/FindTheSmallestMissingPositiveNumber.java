package com.designguru.code.pattern.cyclicsort;

/**
 *
 * Given an unsorted array containing numbers, find the smallest missing positive number in it.
 *
 * Note: Positive numbers start from '1'.
 *
 * Example 1:
 *
 * Input: [-3, 1, 5, 4, 2]
 * Output: 3
 * Explanation: The smallest missing positive number is '3'
 * Example 2:
 *
 * Input: [3, -2, 0, 1, 2]
 * Output: 4
 * Example 3:
 *
 * Input: [3, 2, 5, 1]
 * Output: 4
 * Example 4:
 *
 * Input: [33, 37, 5]
 * Output: 1
 *
 */
public class FindTheSmallestMissingPositiveNumber {

    public int findNumber(int[] nums) {

        for (int i = 0; i < nums.length; ) {

            int k = nums[i];

            if ( k > nums.length ) {
                nums[i] = -1;
            }

            while (  k < nums.length && k > 0 && k != nums[k - 1] ) {
                swap(nums, i, k - 1);
                k = nums[i];
            }

            i++;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (  nums[i] != i + 1 ) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    void swap(int[] nums, int i, int k) {
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }
}
