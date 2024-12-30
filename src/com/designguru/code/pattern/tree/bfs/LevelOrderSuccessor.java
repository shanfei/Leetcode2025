package com.designguru.code.pattern.tree.bfs;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * Given a binary tree and an integer key, find the level order successor of the node containing the given key as a value in the tree.
 * The level order successor is the node that appears right after the given node in the level order traversal.
 *
 */
public class LevelOrderSuccessor {

    public TreeNode findSuccessor(TreeNode root, int key) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean next = false;

        while (!queue.isEmpty()) {

            List<TreeNode> t = new ArrayList<>();

            while (!queue.isEmpty()) {
                if (next) {
                    return queue.poll();
                }

                if (queue.peek().val == key) {
                    next = true;
                }
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

        }


        return root;
    }

}
