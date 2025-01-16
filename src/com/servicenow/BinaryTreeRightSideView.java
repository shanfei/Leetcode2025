package com.servicenow;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 199. Binary Tree Right Side View
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 *
 * Example 2:
 *
 * Input: root = [1,2,3,4,null,null,null,5]
 * Output: [1,3,4,5]
 *
 * Example 3:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 *
 * Example 4:
 *
 * Input: root = []
 * Output: []
 *
 */

interface VisitIf {
    void visit(List<TreeNode> l);
}

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> r = new ArrayList<>();

        if (root == null) {
            return r;
        }

        bfs(root, (l ) -> {
            r.add( l.get(l.size() - 1).val ) ;
        } );

        return r;

    }

    void bfs(TreeNode root, VisitIf visitIf) {


        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            List<TreeNode> treeNodesInTheSameLevel = new ArrayList<>();

            while (!queue.isEmpty()) {
                treeNodesInTheSameLevel.add(queue.poll());
            }

            visitIf.visit(treeNodesInTheSameLevel);

            for ( TreeNode n : treeNodesInTheSameLevel ) {

                if (n.left != null) {
                    queue.add(n.left);
                }

                if (n.right != null) {
                    queue.add(n.right);
                }
            }
        }
    }


}
