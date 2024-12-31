package com.designguru.code.pattern.heap.topk;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * Given a sorted number array and two integers ‘K’ and ‘X’,
 * find ‘K’ closest numbers to ‘X’ in the array. Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.
 *
 * Example 1:
 *
 * Input: [5, 6, 7, 8, 9], K = 3, X = 7
 * Output: [6, 7, 8]
 * Example 2:
 *
 * Input: [2, 4, 5, 6, 9], K = 3, X = 6
 * Output: [4, 5, 6]
 * Example 3:
 *
 * Input: [2, 4, 5, 6, 9], K = 3, X = 10
 * Output: [5, 6, 9]
 *
 */
public class KClosestElement {

    public List<Integer> findClosestElements(int[] arr, int K, int X) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> Math.abs( b - X ) - Math.abs( a - X )) ;

        for (int i = 0; i < arr.length; i++) {
            if (i < K) {
                pq.offer(arr[i]);
            } else {
                if ( Math.abs(pq.peek() - X) > Math.abs(arr[i] - X) )  {
                    pq.poll();
                    pq.offer(arr[i]);
                }
            }
        }

        return pq.stream().toList();
    }
}
