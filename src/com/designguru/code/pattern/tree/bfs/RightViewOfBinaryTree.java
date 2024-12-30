package com.designguru.code.pattern.tree.bfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Given a root of the binary tree, return an array containing nodes in its right view.
 *
 * The right view of a binary tree consists of nodes that are visible when the tree is viewed from the right side.
 * For each level of the tree, the last node encountered in that level will be included in the right view.
 *
 */
public class RightViewOfBinaryTree {

    public static List<Integer> traverse(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

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
            }

            result.add(t.get(t.size() - 1).val);

        }

        return result;
    }

}
