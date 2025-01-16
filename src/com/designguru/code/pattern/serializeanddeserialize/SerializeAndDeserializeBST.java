package com.designguru.code.pattern.serializeanddeserialize;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * serialization means converting a data structure or object into a sequence of bits that can be stored or sent over a network. Deserialization is the reverse process, which takes this sequence and recreates the original object or data structure.
 *
 * Design an algorithm to serialize and deserialize a binary search tree (BST).
 *
 * The serialization should convert the BST into a string, and deserialization should reconstruct the original BST from this string. There is no restriction on how your serialization/deserialization algorithm should work.
 *
 * Examples
 * Example 1:
 * Input: root = [4, 2, 6, 1, 3, null, 7]
 *
 *
 *
 */
public class SerializeAndDeserializeBST {

    // Function to serialize the BST
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder(); // StringBuilder to store the serialized result

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("#").append(",");
                continue;
            } else {
                sb.append(node.val).append(",");
            }

            if ( node.left == null ) {
                queue.offer(null);
            } else {
                queue.offer(node.left);
            }

            if ( node.right == null ) {
                queue.offer(null);
            } else {
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Function to deserialize the serialized string back to BST
    public TreeNode deserialize(String data) {

        String[] cs = data.split(",");

        return insertLevelOrder(0, cs);

    }

    TreeNode insertLevelOrder(int index,  String[] cs) {

        if ( index < cs.length ) {
            TreeNode node = new TreeNode(index);
            node.left =insertLevelOrder(index * 2 + 1, cs);
            node.right = insertLevelOrder(index * 2 + 2, cs);
            return node;
        }

        return null;

    }
}
