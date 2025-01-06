package com.designguru.code.pattern.binarysearch;

/**
 *
 * Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
 * The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
 *
 * Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
 *
 * Example 1:
 *
 * Input: [4, 6, 6, 6, 9], key = 6
 * Output: [1, 3]
 * Example 2:
 *
 * Input: [1, 3, 8, 10, 15], key = 10
 * Output: [3, 3]
 * Example 3:
 *
 * Input: [1, 3, 8, 10, 15], key = 12
 * Output: [-1, -1]
 *
 */
public class NumberRange {

    public int[] findRange(int[] arr, int key) {

        int[] result = new int[] { -1, -1 };

        int start = 0, end = arr.length - 1;

        result[0] = binarySearchWithRange(arr, key, start, end, false);

        if (result[0] != -1) {
            result[1] = binarySearchWithRange(arr, key, start, end, true);
        }


        return result;

    }


    int binarySearchWithRange(int[] arr, int key, int start, int end, boolean isForward) {

        int s = start, e = end;
        int i = -1;

        while ( s <= e ) {

            int mid = s + (e - s) / 2;
            int midVal = arr[mid];

            if ( key == midVal ) {

                i = mid;

                if (isForward) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }


            } else if ( key > midVal ) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return i;
    }

}
