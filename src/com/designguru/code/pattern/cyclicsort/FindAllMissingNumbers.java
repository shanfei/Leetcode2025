package com.designguru.code.pattern.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
 * The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
 *
 * Example 1:
 *
 * Input: [2, 3, 1, 8, 2, 3, 5, 1]
 * Output: 4, 6, 7
 * Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
 * Example 2:
 *
 * Input: [2, 4, 1, 2]
 * Output: 3
 * Example 3:
 *
 * Input: [2, 3, 2, 1]
 * Output: 4
 *
 */
public class FindAllMissingNumbers {

    public List<Integer> findNumbers(int[] nums) {

        List<Integer> missingNumbers = new ArrayList<>();

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
                missingNumbers.add(i + 1);
            }
        }

        return missingNumbers;
    }

    void swap(int[] nums, int i, int k) {
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }

}
