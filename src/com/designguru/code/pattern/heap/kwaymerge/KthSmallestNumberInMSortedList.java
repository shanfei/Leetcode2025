package com.designguru.code.pattern.heap.kwaymerge;

import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
 *
 * Example 1:
 *
 * Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
 * Output: 4
 * Explanation: The 5th smallest number among all the arrays is 4, this can be verified from
 * the merged list of all the arrays: [1, 2, 3, 3, 4, 6, 6, 7, 8]
 * Example 2:
 *
 * Input: L1=[5, 8, 9], L2=[1, 7], K=3
 * Output: 7
 * Explanation: The 3rd smallest number among all the arrays is 7.
 *
 * 虽然是list 但做了和linkedlist 一样的处理
 *
 */
public class KthSmallestNumberInMSortedList {

    public int findKthSmallest(List<List<Integer>> lists, int k) {

        int result = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) ->  a[0] - b[0] );

        for (int i = 0; i < lists.size(); ++i) {
            List<Integer> list = lists.get(i);
            pq.offer(new int[]{ list.get(0), i });
        }

        while ( !pq.isEmpty() ) {

            int[] t = pq.poll();
            if ( --k < 1 ) {
                result = t[0];
                break;
            }

            List<Integer> list = lists.get(t[1]);

            list.remove(0);
            if  ( !list.isEmpty() ) {
                pq.offer(new int[]{ list.get(0), t[1] });
            }

        }

        return result;
    }


}
