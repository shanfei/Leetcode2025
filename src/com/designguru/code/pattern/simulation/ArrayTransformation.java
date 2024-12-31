package com.designguru.code.pattern.simulation;

/**
 *
 * Given an array arr, you transform it daily based on the following rules:
 *
 * If an element is smaller than both its left and right neighbors, increment it by 1.
 * If an element is larger than both its left and right neighbors, decrement it by 1.
 * The first and last elements of the array do not change.
 * Continue transforming the array until no more changes occur. Return the final state of the array.
 *
 * Examples
 * Example 1
 * Input: arr = [5, 2, 8, 1, 6]
 * Expected Output: [5, 5, 5, 5, 6]
 * Justification:
 * On the first day, 2 is incremented to 3, 8 is decremented to 7, and 1 is incremented to 2. The first and last elements remain unchanged. The final state of the array after the first day is [5, 3, 7, 2, 6].
 * After second day: [5, 4, 6, 3, 6].
 * After third day: [5, 5, 5, 4, 6].
 * After forth day: [5, 5, 5, 5, 6].
 * Example 2
 * Input: arr = [3, 7, 1, 5, 2]
 * Expected Output: [3,3,3,3,2]
 * Justification:
 * After first day: [3, 6, 2, 4, 2].
 * After second day: [3, 5, 3, 3, 2].
 * After third day: [3, 4, 3, 3, 2].
 * After forth day: [3, 3, 3, 3, 2].
 * Example 3
 * Input: arr = [9, 9, 9, 9, 9]
 * Expected Output: [9, 9, 9, 9, 9]
 * Justification: All elements are the same. So, arr remains unchanged.
 *
 */

public class ArrayTransformation {

    public static int[] transformArray(int[] arr) {

        int countOfNeedUpdate = arr.length - 2;

        int i = 1;

        while ( countOfNeedUpdate >= 0 ) {

            // reset index
            if ( i == arr.length - 1 ) {
                i = 1;
            }

            int k = needUpdate(arr, i);

            if ( k == 0 ) {
                countOfNeedUpdate--;
                i++;
                continue;
            }

            arr[i] += k;
            i++;
        }

        return arr;
    }

   static int needUpdate(int[] arr, int i) {

        if ( arr[i] < arr[i - 1] && arr[i] < arr[i + 1] ) {
            return 1;
        }

        if ( arr[i] > arr[i - 1] && arr[i] > arr[i + 1] ) {
            return -1;
        }

        return 0;
    }

    public static void main(String[] args) {

        int[][] inputs = {
                {5, 2, 8, 1, 6},
                {3, 7, 1, 5, 2},
                {9, 9, 9, 9, 9}
        };

        for (int[] i : inputs) {
            int[] r = transformArray(i);

            for (int n : r) {
                System.out.print(n + " : ");
            }

            System.out.println();
        }

    }

}
