package com.designguru.code.pattern.slidewindow;

/**
 *
 * Given an array of positive numbers and a positive number 'k,'
 * find the maximum sum of any contiguous subarray of size 'k'.
 *
 */
public class MaxSumSubArrayOfSizeK {

    public int findMaxSumSubArray(int k, int[] arr) {

        int maxSum = 0;
        int tmpSum = 0;

        for (int  i = k - 1 ; i < arr.length; ++i) {

            if (tmpSum == 0) {
                for (int j = 0; j < k; ++j) {
                    tmpSum += arr[i - j];
                }
            } else {
                tmpSum += arr[i];
            }

            maxSum = Math.max(tmpSum, maxSum);

            tmpSum -= arr[i - k + 1];
        }

        return maxSum;
    }
}
