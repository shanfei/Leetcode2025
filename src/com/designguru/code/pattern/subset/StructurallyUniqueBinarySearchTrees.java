package com.designguru.code.pattern.subset;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a number ‘n’, write a function to return all structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’?
 *
 * Example 1:
 *
 * Input: 2
 * Output: List containing root nodes of all structurally unique BSTs.
 * Explanation: Here are the 2 structurally unique BSTs storing all numbers from 1 to 2:
 *
 *
 *
 */
public class StructurallyUniqueBinarySearchTrees {

    public static List<TreeNode> findUniqueTrees(int n) {
        List<TreeNode> list = new ArrayList<>();

        if (n == 1) {
            list.add(new TreeNode(1));
        } else if (n > 0) {
            list.addAll(buildTree(1, n));
        }
        return list;
    }

    public static List<TreeNode> buildTree(int start, int end) {

        if (start >= end) {
            return new ArrayList<>();
        }

        List<TreeNode> res = new ArrayList<>();

        for (int i = start; i <= end; i++) {

            List<TreeNode> left = buildTree(start, i - 1);
            List<TreeNode> right = buildTree(i + 1, end);

            if (!left.isEmpty() && !right.isEmpty()) {
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        if (l.val < root.val) {
                            root.left = l;
                        }

                        if (r.val > root.val) {
                            root.right = r;
                        }

                        res.add(root);
                    }
                }
            }

            if (left.isEmpty() && !right.isEmpty()) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);

                    if (r.val > root.val) {
                        root.right = r;
                    }

                    res.add(root);
                }
            }


            if (right.isEmpty() && !left.isEmpty()) {
                for (TreeNode r : left) {
                    TreeNode root = new TreeNode(i);

                    if (r.val < root.val) {
                        root.left = r;
                    }

                    res.add(root);
                }
            }


            if (left.isEmpty() && right.isEmpty()) {
                TreeNode root = new TreeNode(i);
                res.add(root);
            }

        }

        return res;

    }

}
