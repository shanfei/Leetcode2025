package com.designguru.code.pattern.linkedlist.reverse.inplace;

import common.ListNode;

/**
 *
 * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
 *
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 *
 */
public class ReverseKElementSublist {

    public ListNode reverse(ListNode head, int k) {
        ListNode h = head;

        ListNode ret = null;
        ListNode prevHeader = null;
        ListNode prevTail = null;

        while (h != null) {

            ListNode ph = h;

            for (int i = 0; i < k && ph != null; ++i) {

                ListNode n = ph.next;
                ph.next = prevHeader;
                prevHeader = ph;
                ph = n;

            }

            if (prevTail != null) {
                prevTail.next = prevHeader;
            } else {
                ret = prevHeader;
            }

            prevTail = h;
            prevTail.next = null;

            h = ph;

        }

        return ret;
    }


}
