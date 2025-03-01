package com.leetcode.amazon;

import common.TreeNode;

import java.util.*;


/**
 *
 * Given the root of a binary tree and an array of TreeNode objects nodes, return the lowest common ancestor (LCA) of all the nodes in nodes. All the nodes will exist in the tree, and all values of the tree's nodes are unique.
 *
 * Extending the definition of LCA on Wikipedia: "The lowest common ancestor of n nodes p1, p2, ..., pn in a binary tree T is the lowest node that has every pi as a descendant (where we allow a node to be a descendant of itself)
 * for every valid i". A descendant of a node x is a node y that is on the path from node x to some leaf node.
 *
 * tech 1 * count when return from recursive function
 * tech 2 * find all nodes in a loop using hashSet
 */
public class LowestCommonAncestorOfBinaryTreeIV {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

        Set<Integer> targets = new HashSet<>();
        for ( TreeNode nv : nodes ) {
            targets.add(nv.val);
        }

        List<TreeNode> lcr = new ArrayList<>();

        levelOfNode(root, targets, lcr);

        return lcr.get(0);

    }


   int levelOfNode(TreeNode node, Set<Integer> targets, List<TreeNode> lcr) {

        int foundCount = 0;

        if ( node == null ) {
            return foundCount;
        }

        // to the most deep level
        foundCount += levelOfNode(node.left, targets, lcr);
        foundCount += levelOfNode(node.right, targets, lcr);

        if ( targets.contains(node.val) ) {
            foundCount += 1;
        }

        if ( foundCount == targets.size() && lcr.isEmpty() ) {
            lcr.add(node);
        }

        return foundCount;
    }

}
