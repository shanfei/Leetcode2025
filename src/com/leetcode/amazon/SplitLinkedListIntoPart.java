package com.leetcode.amazon;

import common.ListNode;

/**
 *
 * Given a head of the singly linked list and integer k, split the list into k consecutive parts and return them.
 *
 * The length of each part should not differ more than 1, and it may lead to some parts being null.
 *
 * The order of parts should be the same as given in the input list,
 * and parts in the start should have a size greater than or equal to the parts in the end.
 *
 * Examples
 *
 * Example 1:
 *
 * Input: head = [1, 2, 3, 4, 5, 6, 7], k = 3
 * Expected Output: [[1, 2, 3], [4, 5], [6, 7]]
 * Justification: The list of 8 elements is divided into 3 parts.
 * The first part has 3 elements and the last two parts have 2 elements, distributing the nodes as evenly as possible.
 *
 * Example 2:
 *
 * Input: head = [1, 2, 3], k = 4
 * Expected Output: [[1], [2], [3], []]
 * Justification: The list of 3 elements is divided into 4 parts,
 * resulting in the first three parts having one element each and the last one part being empty, as there are fewer nodes than parts.
 *
 *
 * Example 3:
 *
 * Input: head = [1, 2, 3, 4, 5, 6, 7], k = 2
 * Expected Output: [[1, 2, 3, 4], [5, 6, 7]]
 * Justification: The list of 7 elements is divided into 2 parts. The first part contains 4 elements and the second part contains 3 elements, making the parts as equal in size as possible.
 *
 *
 */
public class SplitLinkedListIntoPart {

    public ListNode[] splitListToParts(ListNode root, int k) {

        ListNode[] parts = new ListNode[k];

        ListNode r = root;

        int c = 0;

        while ( r != null ) {
            r = r.next;
            c++;
        }

        int l = c / k;
        int d = c % k;

        ListNode rr = root;

        for ( int i = 0; i < k; i++ ) {

            if (rr == null) break;

            parts[i] = rr;

            for ( int j = 0; j < l + ( i < d ? 1 : 0 ) - 1; j++) {
                rr = rr.next;
            }

            if ( rr != null ) {

                ListNode rrr = rr.next;

                rr.next = null;

                rr = rrr;
            }

        }


        return parts;
    }


}
