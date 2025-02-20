package com.meta.tree;

import common.TreeNode;

/**
 *
 *  Leetcode 236
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 */
public class LowestCommonAcestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return lowestCommonAncestorR(root,p,q);

    }

    protected TreeNode lowestCommonAncestorR(TreeNode root, TreeNode p, TreeNode q) {

        if ( root == null ) {
            return null;
        } else if (root.equals(p) || root.equals(q)) {
            return root;
        }

        int found = 0;

        TreeNode left = lowestCommonAncestorR(root.left, p, q);
        TreeNode right = lowestCommonAncestorR(root.right, p, q);

        if (left != null) {
            found++;
        }

        if (right != null) {
            found++;
        }

        if (found == 2) {
            return root;
        }

        return left != null ? left : right != null ? right : null;


    }
}
