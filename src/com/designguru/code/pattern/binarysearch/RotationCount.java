package com.designguru.code.pattern.binarysearch;

/**
 *
 * Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.
 *
 * You can assume that the array does not have any duplicates.
 *
 * Note: You need to solve the problem in  time complexity.
 *
 */
public class RotationCount {

    int findPivotInRotatedArray(int[] arr) {

        int start = 0, end = arr.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if ( ( mid + 1 < arr.length && mid - 1 > 0 && arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1] ) ||
                    ( mid + 1 > arr.length && arr[mid] > arr[mid - 1] ) ||
                    ( mid - 1 < 0 && arr[mid] > arr[mid + 1] )
            ) {
                return mid;
            } else if (arr[start] > arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end <= 0 ? 0 : ( start >= arr.length  ? arr.length - 1 : start );
    }

    public int countRotations(int[] arr) {
        int p = findPivotInRotatedArray(arr);

        return ( p + 1 ) % arr.length;
    }
}
