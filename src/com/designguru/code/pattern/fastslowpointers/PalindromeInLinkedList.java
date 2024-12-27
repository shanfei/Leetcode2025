package com.designguru.code.pattern.fastslowpointers;

import common.ListNode;

/**
 *
 *
 *
 */
public class PalindromeInLinkedList {

    public boolean isPalindrome(ListNode head) {

        ListNode m = findMidPoint(head);

        // reverse the second part;
        ListNode rh = reverse(m);

        ListNode h = head;

        while (h != m) {

            if (h.val != rh.val) return false;

            h = h.next;
            rh = rh.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode t = head;
            head = head.next;
            t.next = prev;
            prev = t;
        }

        return prev;

    }

    ListNode findMidPoint(ListNode head) {
        ListNode s = head, f = head;

        while ( f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }

        return s;
    }
}
