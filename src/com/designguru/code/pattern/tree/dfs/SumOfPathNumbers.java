package com.designguru.code.pattern.tree.dfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree where each node can only have a digit (0-9) value,
 * each root-to-leaf path will represent a number.
 * Find the total sum of all the numbers represented by all paths.
 *
 */
public class SumOfPathNumbers {

    public int findSumOfPathNumbers(TreeNode root) {

        List<Integer> path = new ArrayList<>();

        hasPath(root, path,0);

        int sum = 0;
        for (int r : path) {
            sum += r;
        }
        return sum;
    }

    public void hasPath(TreeNode root, List<Integer> totalSum, int sum) {

        if ( root.left == null && root.right == null ) {
            totalSum.add(sum * 10 + root.val);
            return;
        }

        int s = sum * 10 + root.val;

        if ( root.left != null ) {
            hasPath(root.left, totalSum, s);
        }

        if ( root.right != null ) {
            hasPath(root.right, totalSum, s);
        }
    }
}
