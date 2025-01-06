package com.designguru.code.pattern.binarysearch;

/**
 *
 * Find the maximum value in a given Bitonic array. An array is considered bitonic if it is first monotonically increasing and then monotonically decreasing.
 *
 * In other words, a bitonic array starts with a sequence of increasing elements, reaches a peak element, and then follows with a sequence of decreasing elements. The peak element is the maximum value in the array.
 *
 * Example 1:
 *
 * Input: [1, 3, 8, 12, 4, 2]
 * Output: 12
 * Explanation: The maximum number in the input bitonic array is '12'.
 * Example 2:
 *
 * Input: [3, 8, 3, 1]
 * Output: 8
 * Example 3:
 *
 * Input: [1, 3, 8, 12]
 * Output: 12
 * Example 4:
 *
 * Input: [10, 9, 8]
 * Output: 10
 *
 */
public class BitonicArrayMaxim {

    public int findMax(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid + 1 < arr.length && arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return arr[start];

    }

}
