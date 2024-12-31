package com.designguru.code.pattern.heap.kwaymerge;

import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * Given ‘M’ sorted arrays, find the smallest range that includes at least one number from each of the ‘M’ lists.
 *
 * Example 1:
 *
 * Input: L1=[1, 5, 8], L2=[4, 12], L3=[7, 8, 10]
 * Output: [4, 7]
 * Explanation: The range [4, 7] includes 5 from L1, 4 from L2 and 7 from L3.
 * Example 2:
 *
 * Input: L1=[1, 9], L2=[4, 12], L3=[7, 10, 16]
 * Output: [9, 12]
 * Explanation: The range [9, 12] includes 9 from L1, 12 from L2 and 10 from L3
 *
 */
public class SmallestNumberRange {

    public int[] findSmallestRange(List<List<Integer>> lists) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>( (a, b) -> a[0] - b[0] );

        int[] ret = new int[] { 0, 0 };

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); ++i) {
            List<Integer> list = lists.get(i);
            minHeap.offer(new int[]{ list.get(0), i, 0 });
            max = Math.max(max, list.get(0));
        }

        int minRange = max - minHeap.peek()[0];
        ret[0] = minHeap.peek()[0];
        ret[1] = max;

        while ( !minHeap.isEmpty() ) {

            int[] t = minHeap.poll();

            int topListIndex = t[1];
            int topListCurrentIndex = t[2];

            if ( topListCurrentIndex < lists.get(topListIndex).size() - 1 ) {
                int nextTop = lists.get(topListIndex).get(++topListCurrentIndex);
                max = Math.max(nextTop, max);
                minHeap.offer(new int[]{nextTop, topListIndex, topListCurrentIndex});
            } else {
                break;
            }

            if ( minRange > max - minHeap.peek()[0] ) {
                minRange = max - minHeap.peek()[0];
                ret[0] = minHeap.peek()[0];
                ret[1] = max;
            }

        }

        return ret;
    }


}
