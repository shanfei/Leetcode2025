package com.designguru.code.pattern.slidewindow;

/**
 *
 * Given an array containing 0s and 1s,
 * if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 *
 */
public class LongestSubArrayWithOnesAfterReplacement {

    public int findLength(int[] arr, int k) {
        int maxLength = 0;

        int s = 0;

        int oneCountInSubArray = 0;

        for (int e = 0; e < arr.length; e++) {

            int n = arr[e];

            if ( n == 1 ) {
                oneCountInSubArray++;
            }

            while (isExceedOneCountLimitK(e, s, oneCountInSubArray, k)) {
                int m = arr[s++];
                if (m == 1) {
                    oneCountInSubArray--;
                }
            }

            maxLength = Math.max(maxLength, e - s + 1);

        }

        return maxLength;
    }

    boolean isExceedOneCountLimitK(int e, int s, int oneCountInSubarray, int k) {
        return e - s + 1 - oneCountInSubarray > k;
    }

}
