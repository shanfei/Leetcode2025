package com.designguru.code.pattern.subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Given a set of distinct numbers, find all of its permutations.
 *
 * Permutation is defined as the re-arranging of the elements of the set. For example, {1, 2, 3} has the following six permutations:
 *
 * {1, 2, 3} {1, 3, 2} {2, 1, 3} {2, 3, 1} {3, 1, 2} {3, 2, 1}
 *
 * If a set has  distinct elements it will have  permutations.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 *
 */
public class Permutations {

    public List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutations(nums, result, new ArrayList<>());
        return result;
    }

    void findPermutations(int[] nums, List<List<Integer>> subsets,  List<Integer> path) {

        if ( path.size() == nums.length ) {
            subsets.add(new ArrayList<>(path));
            return;
        }

        Set<Integer> cache = new HashSet<>(path);

        for ( int i = 0; i < nums.length; i++ ) {
            if ( !cache.contains(nums[i]) ) {
                path.add(nums[i]);
                findPermutations(nums, subsets, path);
                path.remove(path.size() - 1);
            }
        }

    }

}
