package com.designguru.code.pattern.twopointers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Problem Statement
 * Given an array with positive numbers and a positive target number,
 * find all of its contiguous subarrays whose product is less than the target number.
 *
 * Example 1:
 *
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 * Example 2:
 *
 * Input: [8, 2, 6, 5], target=50
 * Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
 * Explanation: There are seven contiguous subarrays whose product is less than the target.
 *
 */
public class SubarraysWithProductLessThanATarget {

    public List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int f = 0;
        int s = 0;

        int p = arr[0];

        while ( f < arr.length ) {

            if (p >= target) {
                p /= arr[s++];
            } else {
                List<List<Integer>> rs = addToResultSet(arr, s, f);
                result.addAll(rs);
                f++;
                if (f < arr.length) {
                    p *= arr[f];
                }
            }
        }

        return result;
    }

    List<List<Integer>> addToResultSet(int[] arr, int s, int f) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> a = new ArrayList<>();
        for ( int i = s; i <= f;  ++i ) {
            a.add(arr[i]);
        }

        Iterator<Integer> it = a.iterator();

        while ( it.hasNext() ) {
            result.add(0, new ArrayList<>(a));
            it.remove();
        }

        return result;
    }

}
