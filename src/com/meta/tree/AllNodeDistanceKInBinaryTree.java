package com.meta.tree;

import common.TreeNode;

import java.util.*;

/**
 *
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the target node.
 *
 * You can return the answer in any order.
 *
 */
public class AllNodeDistanceKInBinaryTree {

    Map<TreeNode, TreeNode> parentNodes = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ret = new ArrayList<>();

        addParent(root, null);

        dfs(target, k, ret , new HashSet<>());

        return ret;

    }

    void addParent(TreeNode c, TreeNode p) {
        if (c != null) {
            parentNodes.putIfAbsent(c, p);
            addParent(c.left, c);
            addParent(c.right, c);
        }
    }

    void dfs(TreeNode c,  int k, List<Integer> ret, Set<Integer> visited) {

        if ( c == null || visited.contains(c.val) ) {
            return;
        }

        visited.add(c.val);
        if ( k == 0 ) {
            ret.add(c.val);
            return;
        }

        dfs(c.left,  k - 1,  ret,  visited);
        dfs(c.right,  k - 1,  ret,  visited);
        dfs(parentNodes.get(c),  k - 1,  ret,  visited);

    }
}
