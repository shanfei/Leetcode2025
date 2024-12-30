package com.designguru.code.pattern.tree.bfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Given a root of the binary tree, find the minimum depth of a binary tree.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.
 *
 */
public class MinimumDepthOfBinaryTree {

    public int findDepth(TreeNode root) {

        int minimumTreeDepth = Integer.MAX_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int level = 1;

        while (!queue.isEmpty()) {

            List<TreeNode> t = new ArrayList<>();

            while (!queue.isEmpty()) {
                t.add(queue.poll());
            }

            for (TreeNode node : t) {
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.left == null && node.right == null) {
                    minimumTreeDepth = Math.min(minimumTreeDepth, level);
                }
            }

            level++;

        }

        return minimumTreeDepth;
    }

}
