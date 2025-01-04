package com.designguru.code.pattern.tree.dfs;

import common.TreeNode;

/**
 *
 * Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.
 *
 * A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.
 * The path must contain at least one node.
 *
 */
public class PathWithMaxSum {

    private static int globalMaximumSum;

    public int findMaximumPathSum(TreeNode root) {
        globalMaximumSum = Integer.MIN_VALUE;
        findMaximumPathSumHelper(root);
        return globalMaximumSum;
    }

    public int findMaximumPathSumHelper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(findMaximumPathSumHelper(root.left), 0);
        int right = Math.max(findMaximumPathSumHelper(root.right), 0);

        int local_treeDiameter = right + left + root.val;

        globalMaximumSum = Math.max(globalMaximumSum, local_treeDiameter);

        return Math.max(left, right) + root.val;
    }
}
