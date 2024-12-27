package com.designguru.code.pattern.fastslowpointers;

import common.ListNode;

public class MidOfTheLinkedList {

    public ListNode findMiddle(ListNode head) {

        ListNode slow = head, fast = head;

        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
