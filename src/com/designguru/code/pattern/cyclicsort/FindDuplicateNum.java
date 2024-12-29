package com.designguru.code.pattern.cyclicsort;

/**
 *
 * We are given an unsorted array containing n+1 numbers taken from the range 1 to n.
 * The array has only one duplicate but it can be repeated multiple times.
 * Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
 *
 * Example 1:
 *
 * Input: [1, 4, 4, 3, 2]
 * Output: 4
 * Example 2:
 *
 * Input: [2, 1, 3, 3, 5, 4]
 * Output: 3
 * Example 3:
 *
 * Input: [2, 4, 1, 4, 4]
 * Output: 4
 *
 *
 */
public class FindDuplicateNum {

    public int findNumber(int[] nums) {

        int ret = 0;

        for (int i = 0; i < nums.length; ) {

            int k = nums[i] - 1;

            while ( k != nums[k] - 1 ) {
                swap(nums, i, k);
                k = nums[i] - 1;
            }

            i++;
        }

        for (int i = 0; i < nums.length; ++i) {
            if ( nums[i] != i + 1 ) {
                return nums[i];
            }
        }

        return -1;

    }

    void swap(int[] nums, int i, int k) {
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }
}
