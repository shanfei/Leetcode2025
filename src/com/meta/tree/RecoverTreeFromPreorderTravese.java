package com.meta.tree;

import common.TreeNode;

import java.util.Stack;


/**
 *
 * "1-2--3---4-5--6---7"
 *
 */
public class RecoverTreeFromPreorderTravese {

    TreeNode root;

    public TreeNode recoverFromPreorder(String traversal) {

        buildTreeNode(traversal, 0, new Stack<>(), 0);

        return root;

    }

    void buildTreeNode(String sb, int s, Stack<TreeNode> path, int level) {

        if (s == sb.length()) {
            return;
        }

        int currentLevel = 0;

        while ( sb.charAt(s) == '-' ) {
            currentLevel++;
            s++;
        }

        while ( !path.isEmpty() && currentLevel <= level ) {
            path.pop();
            level--;
        }

        // level less than current level return
        int[] pair = parseInteger(sb, s);

        int c = pair[0];
        s = pair[1];

        TreeNode p = path.isEmpty() ? null : path.peek();

        TreeNode node = new TreeNode(c);

        if (!path.isEmpty() && path.size() > currentLevel ) {
            path.pop();
        }

        path.push(node);

        if (p == null) root = node;

        if ( p != null && p.left == null ) {
            p.left = node;
        } else if (p != null && p.left != null && p.right == null ) {
            p.right = node;
        }

        buildTreeNode(sb, s+1, path, currentLevel);

    }

    int[] parseInteger(String sb, int s) {

        int r = 0;

        while (s < sb.length() && Character.isDigit(sb.charAt(s))) {
            int t = ( sb.charAt(s) - '0' ) ;
            r  *= 10;
            r  +=  t;
            s++;
        }

        s--;

        return new int[]{r,s};
    }
}
