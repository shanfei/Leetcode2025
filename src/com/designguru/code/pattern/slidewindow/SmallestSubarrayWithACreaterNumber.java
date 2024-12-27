package com.designguru.code.pattern.slidewindow;

/**
 *
 * Given an array of positive integers and a number ‘S,’
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to 'S'.
 * Return 0 if no such subarray exists.
 *
 */
public class SmallestSubarrayWithACreaterNumber {

    public int findMinSubArray(int S, int[] arr) {

        int sum = 0;
        int windowS = 0;
        int windowE = 0;
        int l = Integer.MAX_VALUE;

        while (windowE < arr.length) {
            if (sum >= S) {
                l = Math.min(l, windowE - windowS + 1);
                sum -= arr[windowS];
                windowS++;
                if (sum < S) {
                    windowE++;
                }
            } else {
                sum += arr[windowE];
                if (sum < S) {
                    windowE++;
                }
            }
        }

        return l == Integer.MAX_VALUE ? 0 : l;
    }
}
