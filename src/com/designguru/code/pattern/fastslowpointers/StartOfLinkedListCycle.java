package com.designguru.code.pattern.fastslowpointers;

import common.ListNode;

/**
 *
 * 2 steps
 *
 * 1. find the meet point
 * 2. from header and meet point step at the same time
 *
 */
public class StartOfLinkedListCycle {

    public ListNode findCycleStart(ListNode head) {

        ListNode meetNode = findTheMeetingPoint(head);

        if (meetNode == null) return head;

        //reset fast to head;

        ListNode p = meetNode;
        ListNode s = head;

        while (s != p) {
            s = s.next;
            p = p.next;
        }

        return s;
    }

    ListNode findTheMeetingPoint(ListNode head) {

        ListNode fast = head, slow = head;

        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) return fast;
        }

        return null;

    }
}
