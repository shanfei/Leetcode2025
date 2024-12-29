package com.designguru.code.pattern.stack.monotonic;

import common.ListNode;

import java.util.Stack;

/**
 *
 * Given the head node of a singly linked list,
 * modify the list such that any node that has a node with a greater value to its right gets removed.
 * The function should return the head of the modified list.
 *
 * Examples:
 *
 * Input: 5 -> 3 -> 7 -> 4 -> 2 -> 1
 * Output: 7 -> 4 -> 2 -> 1
 * Explanation: 5 and 3 are removed as they have nodes with larger values to their right.
 *
 * Input: 1 -> 2 -> 3 -> 4 -> 5
 * Output: 5
 * Explanation: 1, 2, 3, and 4 are removed as they have nodes with larger values to their right.
 *
 * Input: 5 -> 4 -> 3 -> 2 -> 1
 * Output: 5 -> 4 -> 3 -> 2 -> 1
 * Explanation: None of the nodes are removed as none of them have nodes with larger values to their right.
 *
 * Solution
 * We can the monotonic stack strategy to keep track of the highest-valued nodes in the linked list,
 * ensuring that any node with a higher value to its right gets removed.
 *
 * Starting from the head of the list, we will traverse each node.
 * At each node, we will check the value of the node against the node at the top of the stack.
 * If the current node has a higher value, we will pop the top value from the stack.
 * We will keep repeating this until we encounter a node with a higher value or the stack is empty.
 * Then, the current node is pushed onto the stack.
 * This process ensures that the stack only contains nodes in decreasing order from bottom to top.
 *
 */
public class RemoveNodesFromLinkedList {

    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode ph = head;

        while ( ph != null ) {

            if (stack.isEmpty() || stack.peek().val >= ph.val) {
                stack.push(ph);
            } else {
                while ( !stack.isEmpty() && stack.peek().val < ph.val ) {
                    ListNode tmp = stack.pop();
                    tmp.next = null;
                }

                if (!stack.isEmpty()) {
                    ListNode tmp = stack.peek();
                    tmp.next = ph;
                } else {
                    head = ph;
                }

                stack.push(ph);
            }

            ph = ph.next;
        }


        return head;
    }
}
