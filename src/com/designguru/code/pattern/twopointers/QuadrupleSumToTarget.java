package com.designguru.code.pattern.twopointers;

import java.util.*;

/**
 *
 * Problem Statement
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.
 *
 * Example 1:
 *
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 * Example 2:
 *
 * Input: [2, 0, -1, 1, -2, 2], target=2
 * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 *
 */
public class QuadrupleSumToTarget {

    public List<List<Integer>> searchQuadruplets(int[] arr, int target) {

        List<List<Integer>> quadruplets = new ArrayList<>();

        Arrays.sort(arr);

        Set<Integer> s = new HashSet<>();


        for (int i = 0; i < arr.length - 3; ++i) {

            int a = arr[i];

            if ( s.contains(a) ) {
                continue;
            }

            s.add(a);

            Set<Integer> sj = new HashSet<>();

            for (int j = i + 1; j < arr.length - 2; ++j) {



                int b = arr[j];

                if ( sj.contains(b) ) {
                    continue;
                }

                sj.add(b);

                List<List<Integer>> r = findTwoSum(target - a - b, j + 1, arr, a, b);
                quadruplets.addAll(r);


            }


        }

        return quadruplets;
    }

    List<List<Integer>> findTwoSum(int target, int index, int[] arr,int i, int j) {

        int low = index;
        int high = arr.length - 1;

        List<List<Integer>> re = new ArrayList<>();

        Set<Integer> si = new HashSet<>();
        Set<Integer> sj = new HashSet<>();

        while ( low < high ) {

            int sum = arr[low] + arr[high];


            if ( sum < target ) {
                low++;
            } else if ( sum > target ) {

                high--;

            } else {

                if (si.contains(arr[low])) {
                    low++;

                    continue;
                }



                si.add(arr[low]);

                if (sj.contains(arr[high])) {
                    high--;
                    continue;
                }

                sj.add(arr[high]);



                List<Integer> r = new ArrayList<>();
                r.add(i);
                r.add(j);

                r.add(arr[low++]);
                r.add(arr[high--]);

                re.add(r);

            }
        }

        return re;
    }


}
