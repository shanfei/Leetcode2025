package com.designguru.code.pattern.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given an array of distinct positive integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * Example 1:
 *
 * Input: candidates = [2, 3, 6, 7], target = 7
 * Output: [[2, 2, 3], [7]]
 * Explanation: The elements in these two combinations sum up to 7.
 * Example 2:
 *
 * Input: candidates = [2, 4, 6, 8], target = 10
 * Output: [[2,2,2,2,2], [2,2,2,4], [2,2,6], [2,4,4], [2,8], [4,6]]
 * Explanation: The elements in these six combinations sum up to 10.
 *
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        if (candidates.length == 0) {
            return res;
        }

        for (int i = 0; i < candidates.length; ++i) {
            combinationSumRecursive(candidates, target, res, new ArrayList<>(), i, 0);
        }

        if (res.isEmpty()) {
            res.add(new ArrayList<>());
        }

        return res;
    }

    void combinationSumRecursive(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int currentIndex, int currentSum) {

        if ( currentSum > target ) {
            return;
        }

        int sum = currentSum + candidates[currentIndex];
        path.add(candidates[currentIndex]);

        if ( sum == target ) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1 );
            return;
        }

        for ( int i = currentIndex; i < candidates.length; ++i ) {
            combinationSumRecursive(candidates, target, res, path, i, sum);
        }

        path.remove(path.size() - 1);

    }

}
