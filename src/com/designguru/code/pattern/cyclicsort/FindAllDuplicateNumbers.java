package com.designguru.code.pattern.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * We are given an unsorted array containing n numbers taken from the range 1 to n.
 * The array has some numbers appearing twice, find all these duplicate numbers using constant space.
 *
 * Example 1:
 *
 * Input: [3, 4, 4, 5, 5]
 * Output: [4, 5]
 * Example 2:
 *
 * Input: [5, 4, 7, 2, 3, 5, 3]
 * Output: [3, 5]
 *
 */
public class FindAllDuplicateNumbers {

    public List<Integer> findNumbers(int[] nums) {

        List<Integer> duplicateNumbers = new ArrayList<>();

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
                duplicateNumbers.add(nums[i]);
            }
        }

        return duplicateNumbers;
    }

    void swap(int[] nums, int i, int k) {
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }
}
