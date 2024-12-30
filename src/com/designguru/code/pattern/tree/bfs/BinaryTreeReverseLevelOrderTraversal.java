package com.designguru.code.pattern.tree.bfs;

import common.TreeNode;

import java.util.*;

/**
 *
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (i.e., the lowest level comes first in left to right order.)
 *
 * Examples
 * Example 1
 * Input: root = [1, 2, 3, 4, 5, 6, 7]
 * Expected Output: [[4, 5, 6, 7], [2, 3], [1]]
 * Justification:
 * The third level has 4, 5, 6, and 7 nodes.
 * The second level has 2 and 3 nodes.
 * The first level has a single node with the value 1.
 *
 * Example 2
 * Input: root = [12, 7, 1, null, 9, 10, 5]
 * Expected Output: [[9, 10, 5], [7, 1], [12]]
 * Justification:
 * The third level has 9, 10, and 5 nodes.
 * The second level has 7 and 1 nodes.
 * The first level has a single node with the value 12.
 *
 * Example 3
 * Input: root = [6,5,2,null,null,1,6,3,56,3]
 * Expected Output: [[3,56,3],[1,6],[5,2],[6]]
 * Justification:
 * The fourth level has 3, 56, and 3 nodes.
 * The third level has 1, and 6 nodes.
 * The second level has 5 and 2 nodes.
 * The first level has a single node with the value 6.
 *
 */
public class BinaryTreeReverseLevelOrderTraversal {

    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        Stack<List<Integer>> stack = new Stack<>();

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

            List<Integer> list = new ArrayList<>();
            for (TreeNode node : t) {
                list.add(node.val);
            }

            stack.push(list);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }


        return result;
    }
}
