package com.designguru.code.pattern.tree.dfs;

import common.TreeNode;

/**
 *
 * Given a binary tree, find the length of its diameter.
 * The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
 * The diameter of a tree may or may not pass through the root.
 *
 * Note: You can always assume that there are at least two leaf nodes in the given tree.
 *
 */
public class TreeDiameter {

    private int treeDiameter = 0;

    public int findDiameter(TreeNode root) {
        this.treeDiameter = 0;
        findDiameterHelper(root);
        return this.treeDiameter;
    }

    public int findDiameterHelper(TreeNode root) {

        if (root.left == null && root.right == null) {
            return 1;
        }

        int maxLeft = root.left == null ? 0 : findDiameterHelper(root.left);
        int maxRight = root.right == null ? 0 : findDiameterHelper(root.right);

        int local_treeDiameter = 1 +
                maxLeft + maxRight;

        treeDiameter = Math.max(local_treeDiameter, treeDiameter);

        return Math.max(maxLeft, maxRight) + 1;
    }
}
