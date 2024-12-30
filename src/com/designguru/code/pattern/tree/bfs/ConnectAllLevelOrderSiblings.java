package com.designguru.code.pattern.tree.bfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Given a binary tree, connect each node with its level order successor.
 * The last node of each level should point to the first node of the next level.
 *
 */
public class ConnectAllLevelOrderSiblings {

    public TreeNode connect(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        TreeNode current = null;

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

            if (current != null) {
                current.next = t.get(0);
            }

            for (int i = 0; i < t.size() - 1 ; i++) {
                TreeNode tn = t.get(i);
                TreeNode nn = t.get(i + 1);
                tn.next = nn;
            }

            current = t.get(t.size() - 1);

        }


        return root;
    }

}
