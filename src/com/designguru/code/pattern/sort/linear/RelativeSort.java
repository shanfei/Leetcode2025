package com.designguru.code.pattern.sort.linear;

/**
 *
 * Given two arrays arr1 of length n and arr2 of length m,
 * sort the elements of arr1 such that the relative ordering of items in arr1 is the same as in arr2.
 * Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * It is given that elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Examples
 * Example 1:
 * Input: arr1 = [3, 5, 2, 1, 6, 4, 5, 6], arr2 = [5, 6, 4, 1]
 * Expected Output: [5, 5, 6, 6, 4, 1, 2, 3]
 * Justification: Elements 5, 6, 4 and 1 from arr2 are placed in arr1 first in the same order as in arr2.
 * The remaining elements 2 and 3 are placed at the end in ascending order.
 *
 * Example 2:
 * Input: arr1 = [8, 3, 9, 1, 7, 5], arr2 = [3, 9, 8]
 * Expected Output: [3, 9, 8, 1, 5, 7]
 * Justification: Elements 3, 9 and 8 from arr2 are placed in arr1 first in the same order as in arr2.
 * Remaining elements 1, 5 and 7 are placed at the end in ascending order.
 *
 * Example 3:
 * Input: arr1 = [10, 10, 7, 10, 7, 9], arr2 = [10, 7]
 * Expected Output: [10, 10, 10, 7, 7, 9]
 * Justification: Elements 10 and 7 from arr2 are placed in arr1 first in the same order as in arr2.
 * The remaining element 9 is placed at the end in ascending order.
 *
 */
public class RelativeSort {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] ret = new int[arr1.length];

        // init a  element frequency array
        int max = Integer.MIN_VALUE;

        for ( int n : arr1 ) {
            max = Math.max(max, n);
        }

        int[] frequencyArray = new int[ max + 1 ];

        for ( int n : arr1 ) {
            frequencyArray[n]++;
        }

        int index = 0;
        for ( int n : arr2 ) {
            while ( frequencyArray[n]-- > 0 ) {
                ret[index++] = n;
            }
        }

        for (int i = 0; i < frequencyArray.length; ++i) {
            while ( frequencyArray[i]-- > 0 ) {
                ret[index++] = i;
            }
        }

        return ret;
    }
}
