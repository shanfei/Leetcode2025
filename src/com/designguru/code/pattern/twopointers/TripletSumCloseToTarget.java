package com.designguru.code.pattern.twopointers;


import java.util.Arrays;

/**
 *
 * Given an array of unsorted numbers and a target number,
 * find a triplet in the array whose sum is as close to the target number as possible,
 * return the sum of the triplet. If there are more than one such triplet,
 * return the sum of the triplet with the smallest sum.
 *
 * Example 1:
 *
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: The triplet [-1, 0, 3] has the sum '2' which is closest to the target.
 *
 * There are two triplets with distance '1' from the target: [-1, 0, 3] & [-1, 2, 3].
 * Between these two triplets, the correct answer will be [-1, 0, 3] as it has a sum '2'
 * which is less than the sum of the other triplet which is '4'.
 * This is because of the following requirement: 'If there are more than one such triplet,
 * return the sum of the triplet with the smallest sum.'
 *
 * Example 2:
 *
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 * Example 3:
 *
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 * Example 4:
 *
 * Input: [0, 0, 1, 1, 2, 6], target=5
 * Output: 4
 * Explanation: There are two triplets with distance '1' from target: [1, 1, 2] & [0, 0, 6].
 * Between these two triplets, the correct answer will be [1, 1, 2] as it has a sum '4' which is less than the sum of the other triplet which is '6'.
 * This is because of the following requirement: 'If there are more than one such triplet, return the sum of the triplet with the smallest sum.'
 *
 *
 */
public class TripletSumCloseToTarget {

    public int searchTriplet(int[] arr, int targetSum) {

        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;

        int r = Integer.MAX_VALUE;

        for ( int i = 0; i < arr.length - 2; ++i ) {
            int a = arr[i];
            int d = findClosestTwoSum(targetSum - a, arr, i + 1);
            if ( Math.abs(d) < Math.abs(diff) ) {
                diff = d;
                r = targetSum + d;
            } else if ( Math.abs(d) == Math.abs(diff) ) {
                r = Math.min(r, targetSum + d);
            }
        }

        return r;
    }

    int findClosestTwoSum(int targetSumOfTwo, int[] arr, int s) {

        int minDiff = Integer.MAX_VALUE;

        for (int i = s, j = arr.length - 1; i < j;) {

            int a = arr[i];
            int b = arr[j];
            int sum = a + b;

            int cDiff = sum - targetSumOfTwo;

            if (cDiff == 0) return 0;

            if (Math.abs(minDiff) > Math.abs(cDiff)) {
                minDiff = cDiff;
            }

            if (sum > targetSumOfTwo) {
                j--;
            } else if (sum < targetSumOfTwo) {
                i++;
            }

        }

        return minDiff;

    }

}
