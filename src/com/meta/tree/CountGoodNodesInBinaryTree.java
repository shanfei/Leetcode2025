package com.meta.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 *
 */
public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    int dfs(TreeNode root,  int maxInPath) {

        int r = 0;

        if (root == null) {
            return r;
        }

        int val = root.val;

        if ( maxInPath <= val ) {
            r = 1;
        }

        maxInPath = Math.max(val, maxInPath);

        int lr = dfs(root.left, maxInPath);
        int rr = dfs(root.right, maxInPath);

        return r + lr + rr;

    }



}
