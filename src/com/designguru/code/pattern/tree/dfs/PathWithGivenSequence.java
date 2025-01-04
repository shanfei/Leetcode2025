package com.designguru.code.pattern.tree.dfs;

import common.TreeNode;

/**
 *
 * Given a binary tree and a number sequence,
 * find if the sequence is present as a root-to-leaf path in the given tree.
 *
 */
public class PathWithGivenSequence {

    public boolean findPath(TreeNode root, int[] sequence) {
        return hasPath(root, sequence, 0);
    }

    public boolean hasPath(TreeNode root,  int[] s, int currentIndex) {

        if (root.left == null && root.right == null ) {
            return currentIndex == s.length - 1 && root.val == s[currentIndex];
        }

        if ( root.val != s[currentIndex] ) {
            return false;
        }

        boolean t1 = root.left != null && hasPath(root.left, s, currentIndex + 1);
        boolean t2 = root.right != null && hasPath(root.right, s, currentIndex + 1);

        return t1 || t2;

    }

}
