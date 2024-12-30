package com.designguru.code.pattern.tree.bfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Given a binary tree, populate an array to represent the averages of all of its levels.
 *
 */
public class LevelAveragesInBinaryTree {

    public List<Double> findLevelAverages(TreeNode root) {

        List<Double> result = new ArrayList<>();

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

            double sum = 0d;
            for (TreeNode node : t) {
                sum += node.val;
            }

            result.add(sum / t.size());
        }


        return result;
    }

}
