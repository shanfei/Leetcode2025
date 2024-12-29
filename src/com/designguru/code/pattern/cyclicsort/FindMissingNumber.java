package com.designguru.code.pattern.cyclicsort;

/**
 *
 * Problem Statement
 * We are given an array containing n distinct numbers taken from the range 0 to n.
 * Since the array has only n numbers out of the total n+1 numbers, find the missing number.
 *
 * Example 1:
 *
 * Input: [4, 0, 3, 1]
 * Output: 2
 * Example 2:
 *
 * Input: [8, 3, 5, 2, 4, 6, 0, 1]
 * Output: 7
 *
 * 基本思路 是把 数组元素 换到 一样数字的数组下标
 *
 */
public class FindMissingNumber {

    public static int findMissingNumber(int[] nums) {

        int extractNum = nums.length;

        int index =  nums.length - 1;

        for (int i = 0; i < nums.length; ) {

            int k = nums[i];

            while ( nums[i] != extractNum && k != i ) {
                swap(nums, i, k);
                k = nums[i];

                if (k == extractNum) {
                    index = i;
                }
            }

            i++;
        }

        return index == nums.length - 1 && nums[index] != extractNum ?  extractNum : index ;
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
