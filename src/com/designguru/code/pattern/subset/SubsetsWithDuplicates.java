package com.designguru.code.pattern.subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * Given a set of numbers that might contain duplicates, find all of its distinct subsets.
 *
 * Example 1:
 *
 * Input: [1, 3, 3]
 * Output: [], [1], [3], [1,3], [3,3], [1,3,3]
 * Example 2:
 *
 * Input: [1, 5, 3, 3]
 * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]
 *
 *
 */
public class SubsetsWithDuplicates {

    public List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        for (int num : nums) {

            int n = subsets.size();

            for (int i = 0; i < n; i++) {
                List<Integer> a = new ArrayList<>(subsets.get(i));
                a.add(num);
                subsets.add(a);
            }
        }

        return new ArrayList<>(new HashSet<>(subsets));

    }

}
