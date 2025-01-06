package com.designguru.code.pattern.binarysearch;

/**
 *
 * Given an array of numbers which is sorted in ascending order and also rotated by some arbitrary number, find if a given ‘key’ is present in it.
 *
 * Write a function to return the index of the ‘key’ in the rotated array. If the ‘key’ is not present, return -1. You can assume that the given array does not have any duplicates.
 *
 * Note: You need to solve the problem in  time complexity.
 *
 * Example 1:
 *
 * Input: [10, 15, 1, 3, 8], key = 15
 * Output: 1
 * Explanation: '15' is present in the array at index '1'.
 *
 */
public class SearchInARotatedArray {

    public int search(int[] arr, int key) {
        int p = findPivotInRotatedArray(arr);

        int index = binarySearch( arr, key, 0, p);
        if (index == -1) {
            index = binarySearch( arr, key, p + 1, arr.length - 1);
        }

        return index;
    }

    int binarySearch(int[] arr, int key, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;
    }


    int findPivotInRotatedArray(int[] arr) {

        int start = 0, end = arr.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (mid + 1 < arr.length && mid - 1 > 0 && arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[start] > arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end < 0 ? 0 : ( start >= arr.length  ? arr.length - 1 : start );
    }


}
