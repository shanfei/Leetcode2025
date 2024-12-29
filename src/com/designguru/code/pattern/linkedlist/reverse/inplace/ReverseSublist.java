package com.designguru.code.pattern.linkedlist.reverse.inplace;

import common.ListNode;

/**
 *
 * Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.
 *
 */
public class ReverseSublist {

    public ListNode reverse(ListNode head, int p, int q) {

        ListNode pp = head, pq = head, prev = null, next = null;

        if ( p == q ) return head;

        while ( p-- > 1 && pp != null ) {
            prev = pp;
            pp = pp.next;
        }

        while ( q-- > 1 && pq != null ) {
            pq = pq.next;
            next = pq == null ? null : pq.next;
        }

        ListNode lastNodeOfReversed = pp;

        ListNode h = reverse(pp, pq);

        ListNode ret = prev == null ? h : head;

        if (prev != null) {
            prev.next = h;
        }

        lastNodeOfReversed.next = next;

        return ret;

    }

    public ListNode reverse(ListNode head, ListNode tail) {

        ListNode prev = null, h = head;

        while ( prev != tail ) {
            ListNode n = h.next;
            h.next = prev;
            prev = h;
            h = n;
        }

        return prev;
    }
}
