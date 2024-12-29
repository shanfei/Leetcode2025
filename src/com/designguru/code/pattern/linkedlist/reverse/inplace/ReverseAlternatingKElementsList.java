package com.designguru.code.pattern.linkedlist.reverse.inplace;

import common.ListNode;

/**
 *
 * Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.
 *
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 *
 */
public class ReverseAlternatingKElementsList {

    public ListNode reverse(ListNode head, int k) {
        return reverseEveryKNodesR(head, k, true);
    }

    public ListNode reverseEveryKNodesR(ListNode head, int k, boolean reverse) {

        if (head == null) return null;

        ListNode h = head;

        ListNode prev = null;

        int count = k;

        if (reverse) {

            while ( h != null && count-- > 0 ) {

                ListNode next = h.next;
                h.next = prev;
                prev = h;
                h = next;

            }
        } else {
            count--;
            while ( h.next != null && count-- > 0 ) {
                h = h.next;
            }
        }

        ListNode lastNode = reverse ? head : h;
        ListNode firstNode = reverse ? prev : head;
        ListNode next = reverse ? h : h.next;

        lastNode.next = reverseEveryKNodesR(next, k, !reverse);

        return firstNode;
    }
}
