package com.designguru.code.pattern.twopointers;

/**
 * TODO: need review
 *
 * Problem Statement
 * Given an array containing 0s, 1s and 2s, sort the array in-place.
 * You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 *
 * The flag of the Netherlands consists of three colors: red, white and blue;
 * and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
 *
 * Example 1:
 *
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 * Example 2:
 *
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0 0 1 2 2 2 ]
 *
 */
public class DutchNationalFlagProblem {

    public int[] sort(int[] arr) {

        int low = 0, high = arr.length - 1;

        for (int i = 0; i <= high; ) {

            int c = arr[i];

            if ( c == 0 ) {
                swap(arr, i, low);
                i++;
                low++;
            } else if ( c == 2 ) {
                swap(arr, i, high);
                high--;
            } else {
                i++;
            }
        }

        return arr;
    }

    void swap(int[] arr, int s, int e) {
        int t = arr[s];
        arr[s] = arr[e];
        arr[e] = t;
    }

}
