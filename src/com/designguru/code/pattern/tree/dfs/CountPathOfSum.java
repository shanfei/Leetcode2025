package com.designguru.code.pattern.tree.dfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * //TODO:
 * Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
 * Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).
 *
 */
public class CountPathOfSum {

    public int countPaths(TreeNode root, int S) {
        return countPath(root,  S,  new ArrayList<>());
    }

    private static int countPathsRecursive(TreeNode currentNode, int S,
                                           List<Integer> currentPath) {
        if (currentNode == null)
            return 0;

        // add the current node to the path
        currentPath.add(currentNode.val);
        int pathCount = 0;
        double pathSum = 0; // let's use a double to handle integer overflow for large sums

        // find the sums of all sub-paths in the current path list
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            // if the sum of any sub-path is equal to 'S' we increment our path count.
            if (pathSum == S) {
                pathCount++;
            }
        }

        // traverse the left sub-tree
        pathCount += countPathsRecursive(currentNode.left, S, currentPath);
        // traverse the right sub-tree
        pathCount += countPathsRecursive(currentNode.right, S, currentPath);

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);

        return pathCount;
    }

    public int countPath(TreeNode root, int s, List<Integer> prevPath) {

        if ( root == null ) {
            return 0;
        }

        int totalCount = 0;
        int tmp = root.val;

        if ( s == root.val ) {
            totalCount = 1;
        } else {
            for (int i = prevPath.size() - 1; i >= 0; i--) {
                tmp += prevPath.get(i);
                if (s == tmp) {
                    totalCount = 1;
                    break;
                } else if (tmp > s) {
                    break;
                }
            }
        }

        prevPath.add(root.val);

        int total = totalCount + countPath(root.left, s, prevPath) + countPath(root.right, s, prevPath);

        prevPath.remove(prevPath.size() - 1);

        return total;

    }
}
