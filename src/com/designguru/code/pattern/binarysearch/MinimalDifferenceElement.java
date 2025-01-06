package com.designguru.code.pattern.binarysearch;

public class MinimalDifferenceElement {

    public static int searchMinDiffElement(int[] arr, int key) {
        if (key <= arr[0]) {
            return arr[0];
        }

        if (key >= arr[arr.length - 1]) {
            return arr[arr.length - 1];
        }

        int i = searchFloorOfKey(arr, key);

        return Math.abs(arr[i] - key) <=  Math.abs(key - arr[i + 1]) ? arr[i] : arr[i + 1];
    }

    static int searchFloorOfKey(int[] arr, int key) {
        int start = 0, end = arr.length - 1;

        while ( start <= end ) {

            int mid = start + (end - start) / 2;
            int midVal = arr[mid];

            if ( key == midVal ) {
                return mid;
            } else if ( key > midVal ) {

                int nextStart = mid + 1;

                if (nextStart > end) {
                    return mid;
                }

                start = nextStart;
            } else {

                int nextEnd = mid - 1;

                if (start > nextEnd) {
                    return nextEnd;
                }

                end = nextEnd;
            }
        }

        return -1;
    }
}
