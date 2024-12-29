package com.designguru.code.pattern.linkedlist.reverse.inplace;

import common.ListNode;

public class ReverseLinkedlist {

    public ListNode reverse(ListNode head) {

        ListNode result = null;
        ListNode prev = null, h = head;

        while (h != null) {
            ListNode n = h;
            h = h.next;
            n.next = prev;
            prev = n;
        }

        return prev;
    }
}
