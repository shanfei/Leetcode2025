package com.meta.tree;

import common.TreeNode;

import java.util.*;

public class VerticalOrderOfBinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        verticalTraversal(root, 0, 0,  map);

        List<List<Integer>> ret = new ArrayList<>();

        for ( TreeMap<Integer, List<Integer>> v : map.values() ) {
            List<Integer> w = new ArrayList<>();
            for ( List<Integer> l : v.values() ) {
                Collections.sort(l);
                w.addAll(l);
            }
            ret.add(w);
        }

        return ret;
    }

    void verticalTraversal(TreeNode root, int row, int col,  TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {

        if ( root == null ) {
            return;
        }

        TreeMap<Integer, List<Integer>> m = map.getOrDefault(col, new TreeMap<>());
        List<Integer> vm = m.getOrDefault(row, new ArrayList<>());
        vm.add(root.val);
        m.put(row, vm);
        map.put(col, m);

        verticalTraversal(root.left, row + 1, col - 1, map );
        verticalTraversal(root.right, row + 1, col + 1, map );

    }
}
