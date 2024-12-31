package com.designguru.code.pattern.heap.kwaymerge;


import common.ListNode;

import java.util.PriorityQueue;

/**
 *
 * Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.
 *
 * Example 1:
 *
 * Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
 * Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]
 * Example 2:
 *
 * Input: L1=[5, 8, 9], L2=[1, 7]
 * Output: [1, 5, 7, 8, 9]
 *
 */
public class MergeSortedKList {

    public ListNode merge(ListNode[] lists) {

        ListNode resultHead = null;
        ListNode currentNode = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>( (a, b) ->  a.val - b.val );

        for (ListNode list : lists) {
            pq.offer(list);
        }

        while ( !pq.isEmpty() ) {

            ListNode t = pq.poll();

            if (currentNode == null) {
                currentNode = t;
                resultHead = currentNode;
            } else {
                currentNode.next = t;
                currentNode = currentNode.next;
            }

            ListNode next = t.next;
            if ( next != null ) {
                pq.offer(next);
            }
        }

        return resultHead;
    }


}
