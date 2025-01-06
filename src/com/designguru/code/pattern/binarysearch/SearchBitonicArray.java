package com.designguru.code.pattern.binarysearch;

/**
 *
 * Given a Bitonic array, find if a given ‘key’ is present in it. An array is considered bitonic if it is first monotonically increasing and then monotonically decreasing.
 *
 * In other words, a bitonic array starts with a sequence of increasing elements, reaches a peak element, and then follows with a sequence of decreasing elements. The peak element is the maximum value in the array.
 *
 * Write a function to return the index of the ‘key’. If the 'key' appears more than once, return the smaller index. If the ‘key’ is not present, return -1.
 *
 * Example 1:
 *
 * Input: [1, 3, 8, 4, 3], key=4
 * Output: 3
 * Example 2:
 *
 * Input: [3, 8, 3, 1], key=8
 * Output: 1
 * Example 3:
 *
 * Input: [1, 3, 8, 12], key=12
 * Output: 3
 * Example 4:
 *
 * Input: [10, 9, 8], key=10
 * Output: 0
 *
 */
public class SearchBitonicArray {

    int binarySearch(boolean reverseSorted, int[] arr, int key, int s, int e) {
        int start = s;
        int end = e;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                if (reverseSorted) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (reverseSorted) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }


    public int search(int[] arr, int key) {
        int pivot = findPivot(arr);

        int index = binarySearch(arr[0] >= arr[pivot], arr, key,0, pivot);
        if (index == -1) {
            index = binarySearch(arr[pivot] > arr[arr.length - 1], arr, key, pivot, arr.length - 1);
        }

        return index;
    }

    public int findPivot(int[] arr) {

        int start = 0, end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid + 1 < arr.length && arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return start;
    }

}
