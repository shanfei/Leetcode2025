package com.designguru.code.pattern.twopointers;


import java.util.*;

/**
 *
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 * Example 1:
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]
 * Explanation: There are four unique triplets whose sum is equal to zero. smallest sum.'
 * Example 2:
 *
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 *
 */
public class TripletSumToZero {

    public List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(arr);

        Set<Integer> ss = new HashSet<>();

        for (int i = 0 ; i < arr.length - 2; ++i ) {

            if (ss.contains(arr[i])) {
                continue;
            }

            ss.add(arr[i]);

            int s = 0 - arr[i];

            List<List<Integer>> sumOfTwo = TwoSum(arr, i + 1, s);

            if (sumOfTwo.isEmpty()) continue;

            for (List<Integer> a : sumOfTwo) {
                List<Integer> r = new ArrayList<>();
                r.add(arr[i]);
                r.addAll(a);
                triplets.add(r);
            }


        }

        return triplets;
    }

    List<List<Integer>> TwoSum(int[] arr, int s, int sum) {

        List<List<Integer>> r = new ArrayList<>();

        Set<Integer> ss = new HashSet<>();

        for (int i = s, j = arr.length - 1; i < j; ) {

            if (ss.contains(arr[i])) {
                i++;
                continue;
            }

            if (arr[i] + arr[j] == sum) {

                List<Integer> a = new ArrayList<>();
                a.add(arr[i]);
                a.add(arr[j]);

                ss.add(arr[i]);

                r.add(a);
                j--;
                i++;

            } else if (arr[i] + arr[j] < sum) {
                i++;
            } else {
                j--;
            }
        }

        return r;

    }


}
