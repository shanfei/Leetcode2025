package com.leetcode.amazon;

import common.TreeNode;

public class MaxDiffBetweenAncestor {

    public int maxAncestorDiff(TreeNode root) {
        // ToDo: Write Your Code Here.
        return maxAncestorDiffR(root, root.val, root.val);

    }

    int maxAncestorDiffR(TreeNode root, int min, int max) {

        if ( root == null ) {
            return max - min;
        }

        int l = maxAncestorDiffR(root.left, Math.min(root.val, min), Math.max(root.val, max));
        int r = maxAncestorDiffR(root.right, Math.min(root.val, min), Math.max(root.val, max));

        return Math.max(l, r);

    }
}
