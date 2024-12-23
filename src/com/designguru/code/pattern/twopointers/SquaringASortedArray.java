package com.designguru.code.pattern.twopointers;

import java.util.PriorityQueue;

/**
 *
 * Problem Statement
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 *
 * Example 1:
 *
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 * Example 2:
 *
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 *
 */
public class SquaringASortedArray {

    public int[] makeSquares(int[] arr) {

        int n = arr.length;
        int[] squares = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int a : arr) {
            pq.offer(a * a);
        }

        int i = 0;
        while (!pq.isEmpty()) {
            squares[i++] = pq.poll();
        }

        return squares;
    }
}
