package com.designguru.code.pattern.tree.dfs;

import common.TreeNode;

/**
 *
 * Given a root of the binary tree and an integer ‘S’,
 * return true if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
 * Otherwise, return false.
 *
 * Examples
 * Example 1:
 * Input: root = [1, 2, 3, 4, 5, 6, 7], S = 10
 *
 */
public class BinaryTreePathSum {

    public static boolean hasPath(TreeNode root, int sum) {

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        boolean t1 = root.left != null && hasPath(root.left, sum - root.val);
        boolean t2 = root.right != null && hasPath(root.right, sum - root.val);

        return t1 || t2;
    }

}
