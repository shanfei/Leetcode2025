package com.designguru.code.pattern.twopointers;

import java.util.Arrays;

/**
 *
 * Problem Statement
 * Given an array arr of unsorted numbers and a target sum,
 * count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 *
 * Example 1:
 *
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 * Example 2:
 *
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 *
 */
public class TripletWithSmallestSum {

    public int searchTriplets(int[] arr, int target) {

        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; ++i) {
            int a = arr[i];
            int c = findSumLessThanTargetPair(target - a, arr, i + 1);
            count = count + c;
        }

        return count;
    }

    int findSumLessThanTargetPair(int target, int[] arr, int i) {

        int k = i;

        int count = 0;
        int b = arr.length -1;


        while ( b > k ) {

            int sum = arr[k] + arr[b];

            if (sum >= target) {
                b--;
            } else {
                count += b - k;
                k++;
            }

        }

        return count;

    }


}
