package com.designguru.code.pattern.fastslowpointers;

import common.ListNode;

/**
 *
 * Given the head of a Singly LinkedList,
 * write a method to modify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order.
 * So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 *
 * Your algorithm should use only constant space the input LinkedList should be modified in-place.
 *
 */
public class RearrangeLinkedList {

    public ListNode reorder(ListNode head) {

        ListNode mid = findMidPoint(head);

        ListNode rm = reverse(mid);

        ListNode p = head;
        ListNode m = rm;
        ListNode prev = null;

        while ( p != mid && m != null) {

            if (prev != null) {
                prev.next = p;
            }

            ListNode nm = m.next;
            ListNode np = p.next;

            p.next = m;
            if (m.next != null) {
                m.next = np;
            }

            prev = m;

            p = np;
            m = nm;

        }

        return head;
    }

    ListNode reverse(ListNode h) {
        ListNode prev = null;
        ListNode head = h;

        while ( head != null ) {
            ListNode t = head;
            head = head.next;
            t.next = prev;
            prev = t;
        }

        return prev;
    }

    ListNode findMidPoint(ListNode h) {
        ListNode s = h, f = h;

        while ( f != null && f.next != null) {
            f = f.next.next;
            s = s.next;

            if (f == s) break;
        }

        return s;
    }
}
