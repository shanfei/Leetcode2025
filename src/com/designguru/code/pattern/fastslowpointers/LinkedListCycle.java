package com.designguru.code.pattern.fastslowpointers;

import common.ListNode;

/**
 *
 *
 *
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode fastP = head;
        ListNode slowP = head;

        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;

            if (slowP == fastP) return true;
        }


        return false;
    }
}
