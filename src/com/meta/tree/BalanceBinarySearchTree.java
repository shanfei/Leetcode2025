package com.meta.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values.
 * If there is more than one answer, return any of them.
 *
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 *
 *
 */

enum RotateDirection {
    RIGHT, LEFT
}

public class BalanceBinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {

        List<Integer> inorderTraverseNodes = new ArrayList<>();

        inorderTraverse(root, inorderTraverseNodes);

        return reconstructBalancedBinaryTree(inorderTraverseNodes,0, inorderTraverseNodes.size() - 1);

    }

    public TreeNode reconstructBalancedBinaryTree(List<Integer> inorderTraverseNodes, int start, int end) {

        if ( start > end ) return null;

        int mid = (start + end) / 2;

        Integer root = inorderTraverseNodes.get(mid);

        TreeNode left = reconstructBalancedBinaryTree(inorderTraverseNodes, start, mid - 1);
        TreeNode right = reconstructBalancedBinaryTree(inorderTraverseNodes, mid + 1, end);

        return new TreeNode( root, left, right);

    }

    public void inorderTraverse(TreeNode root, List<Integer> inorderTraverseNodes) {

        if (root == null) {
            return;
        }

        inorderTraverse(root.left, inorderTraverseNodes);
        inorderTraverseNodes.add(root.val);
        inorderTraverse(root.right, inorderTraverseNodes);

    }



    public static void main(String[] args) {

    }
}
