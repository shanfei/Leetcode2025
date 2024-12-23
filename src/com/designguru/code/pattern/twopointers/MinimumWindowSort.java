package com.designguru.code.pattern.twopointers;


/**
 *
 * Problem Statement
 * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 *
 * Example 1:
 *
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 * Example 2:
 *
 * Input: [1, 3, 2, 0, -1, 7, 10]
 * Output: 5
 * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 * Example 3:
 *
 * Input: [1, 2, 3]
 * Output: 0
 * Explanation: The array is already sorted
 * Example 4:
 *
 * Input: [3, 2, 1]
 * Output: 3
 * Explanation: The whole array needs to be sorted.
 *
 */
public class MinimumWindowSort {

    public int sort(int[] arr) {

        int i = 0, j = arr.length - 1;

        int low = 0, high = 0;

        boolean isFoundS = false;
        boolean isFoundE = false;

        while ( i < j  ) {

            if (isFoundS && isFoundE) {
                break;
            }

            if (!isFoundS && arr[i + 1] >= arr[i]) {
                i++;
            } else {
                isFoundS = true;
                low = i;
            }

            if (!isFoundE && arr[j - 1] <= arr[j]) {
                j--;
            } else {
                isFoundE = true;
                high = j;
            }

        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int k = low; k <= high; ++k) {
            max = Math.max(max, arr[k]);
            min = Math.min(min, arr[k]);
        }

        for (int k = 0; k <= low; ++k) {
            if (arr[k] > min ) {
                low = k;
                break;
            }
        }

        for (int k = arr.length - 1; k >= high; --k) {
            if (arr[k] < max) {
                high = k;
                break;
            }
        }

        if (low == 0 && high == 0) {
            return 0;
        }

        if (low == 0) {
            return high + 1;
        }

        if (high == 0) {
            return arr.length - high + 1;
        }

        return high - low + 1;
    }

}
