package com.designguru.code.pattern.tree.dfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 *
 */
public class AllPathsForASum {

    public List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();

        hasPath(root, sum, allPaths, new ArrayList<>());

        return allPaths;
    }

    public void hasPath(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> path) {

        path.add(root.val);

        if ( root.left == null && root.right == null) {

            if (sum == root.val) {
                allPaths.add(new ArrayList<>(path));
            }

            path.remove(path.size() - 1);

            return;
        }


        if (root.left != null) {
            hasPath(root.left, sum - root.val, allPaths, path);
        }

        if (root.right != null) {
            hasPath(root.right, sum - root.val, allPaths, path);
        }


        path.remove(path.size() - 1);



    }
}
