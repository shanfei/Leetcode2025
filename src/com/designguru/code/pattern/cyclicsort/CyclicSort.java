package com.designguru.code.pattern.cyclicsort;

/**
 *
 * We are given an array containing n objects. Each object, when created,
 * was assigned a unique number from the range 1 to n based on their creation sequence.
 * This means that the object with sequence number 3 was created just before the object with sequence number 4.
 *
 * Write a function to sort the objects in-place on their creation sequence number in  without using any extra space.
 * For simplicity, let’s assume we are passed an integer array containing only the sequence numbers,
 * though each number is actually an object.
 *
 * Example 1:
 *
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 * Example 2:
 *
 * Input: [2, 6, 4, 3, 1, 5]
 * Output: [1, 2, 3, 4, 5, 6]
 * Example 3:
 *
 * Input: [1, 5, 6, 4, 3, 2]
 * Output: [1, 2, 3, 4, 5, 6]
 *
 */
public class CyclicSort {

    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int k = nums[i];
            while ( nums[k - 1] != k  ) {
                swap(nums, k - 1, i);
                k = nums[i];
            }
            i++;
        }

        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
