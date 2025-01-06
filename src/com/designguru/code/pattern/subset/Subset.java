package com.designguru.code.pattern.subset;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a set with distinct elements, find all of its distinct subsets.
 *
 * Example 1:
 *
 * Input: [1, 3]
 * Output: [], [1], [3], [1,3]
 * Example 2:
 *
 * Input: [1, 5, 3]
 * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 *
 */
public class Subset {

    public List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>());
        bfs(nums, l);
        return l;
    }

    void bfs(int[] t, List<List<Integer>> l) {

        for (int k : t) {

            int n = l.size();

            for (int i = 0; i < n; i++) {
                List<Integer> subset = new ArrayList<>(l.get(i));
                subset.add(k);
                l.add(subset);
            }
        }

    }



    public void findSubsets(int[] t, List<List<Integer>> l, int index, List<Integer> path) {

        l.add(new ArrayList<>(path));

        if ( index == t.length ) {
            return;
        }

        for ( int i = index; i < t.length; i++ ) {
            path.add(t[i]);
            findSubsets(t, l, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
