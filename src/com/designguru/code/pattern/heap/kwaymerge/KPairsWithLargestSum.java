package com.designguru.code.pattern.heap.kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * Given two sorted arrays in descending order, find ‘K’ pairs with the largest sum where each pair consists of numbers from both the arrays.
 *
 * Example 1:
 *
 * Input: nums1=[9, 8, 2], nums2=[6, 3, 1], K=3
 * Output: [9, 3], [9, 6], [8, 6]
 * Explanation: These 3 pairs have the largest sum. No other pair has a sum larger than any of these.
 * Example 2:
 *
 * Input: nums1=[5, 2, 1], nums2=[2, -1], K=3
 * Output: [5, 2], [5, -1], [2, 2]
 *
 */
public class KPairsWithLargestSum {

    public List<List<Integer>> findKLargestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> lists = new ArrayList<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>( (a, b) -> (a[0] + a[1]) - (b[0] + b[1]) );

        for ( int i = 0; i < nums1.length && i < k; ++i ) {
            for ( int j = 0; j < nums2.length && j < k; ++j ) {

                int[] pair = new int[]{nums1[i], nums2[j]};

                if (minHeap.size() < k) {
                    minHeap.offer(pair);
                } else {
                    int[] topPair = minHeap.peek();

                    // from list
                    int currentSum = nums1[i] + nums2[j];

                    // from PQ
                    int topSum = topPair[0] + topPair[1];

                    if ( currentSum >= topSum ) {
                        minHeap.poll();
                        minHeap.offer(pair);
                    } else {
                        break;
                    }
                }
            }
        }

        while ( !minHeap.isEmpty() ) {
            int[] t = minHeap.poll();
            List<Integer> l = new ArrayList<>();
            l.add(t[0]);
            l.add(t[1]);
            lists.add(l);
        }

        return lists;
    }


}
