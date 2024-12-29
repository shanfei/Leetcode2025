package com.designguru.code.pattern.linkedlist.reverse.inplace;

import common.ListNode;

/**
 *
 * Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.
 *
 */
public class RotateLinkedlist {

    public ListNode rotate(ListNode head, int rotations) {

        int totalCount = totalElements(head);

        if (rotations % totalCount == 0) return head;

        int rotationCount = totalCount - rotations % totalCount;

        ListNode h = head;

        while ( rotationCount-- > 1 ) {
            h = h.next;
        }

        ListNode newHead = h.next;
        h.next = null;

        ListNode p = newHead;

        while ( p.next != null ) {
            p = p.next;
        }

        p.next = head;

        return newHead;
    }

    int totalElements(ListNode head) {

        ListNode h = head;

        int totalCount = 0;

        while ( h != null ) {
            totalCount++;
            h = h.next;
        }

        return totalCount;
    }
}
