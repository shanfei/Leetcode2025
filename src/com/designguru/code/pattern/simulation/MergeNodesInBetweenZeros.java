package com.designguru.code.pattern.simulation;

import common.ListNode;

/**
 *
 * You are given a head of the linked list where each node contains an integer.
 * This list has segments separated by nodes with the value 0. The list starts and ends with a node containing 0.
 *
 * For every pair of consecutive nodes with the value 0, merge all the nodes between them into a single node whose value is the sum of these nodes. The modified linked list should not include any 0 nodes.
 *
 * Return the head of the updated linked list.
 *
 * Examples
 * Example 1:
 *
 * Input: head = [0, 2, 3, 0, 4, 5, 0, 3, 0, 4, 0]
 * Expected Output: [5, 9, 3, 4]
 * Justification: The segments between 0s are [2, 3], [4, 5], [3], and [4]. Summing these segments gives 5, 9, 3, and 4, respectively.
 * Example 2:
 *
 * Input: head = [0, 1, 1, 1, 0, 2, 2, 0]
 * Expected Output: [3, 4]
 * Justification: The segments between 0s are [1, 1, 1] and [2, 2]. Summing these segments gives 3 and 4, respectively.
 * Example 3:
 *
 * Input: head = [0, 5, 0, 10, 15, 0]
 * Expected Output: [5, 25]
 * Justification: The segments between 0s are [5] and [10, 15]. Summing these segments gives 5 and 25, respectively.
 *
 */
public class MergeNodesInBetweenZeros {

    public ListNode mergeNodes(ListNode head) {
        // ToDo: Write Your Code Here.
        return head;
    }
}
