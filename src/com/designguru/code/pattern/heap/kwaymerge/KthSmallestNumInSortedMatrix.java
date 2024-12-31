package com.designguru.code.pattern.heap.kwaymerge;

import java.util.PriorityQueue;

/**
 *
 * Given an N * N matrix where each row and column is sorted in ascending order,
 * find the Kth smallest element in the matrix.
 *
 * Example 1:
 *
 * Input: Matrix=[
 *     [2, 6, 8],
 *     [3, 7, 10],
 *     [5, 8, 11]
 *   ],
 *   K=5
 * Output: 7
 * Explanation: The 5th smallest number in the matrix is 7.
 *
 */
public class KthSmallestNumInSortedMatrix {

    public int findKthSmallest(int[][] matrix, int k) {

        int result = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) ->  a[0] - b[0] );
        int[] indexes = new int[matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            int[] list = matrix[i];
            pq.offer(new int[]{list[0], i});
        }

        while ( !pq.isEmpty() ) {
            int[] t = pq.poll();

            if ( --k < 1 ) {
                result = t[0];
                break;
            }

            int listIndex = t[1];
            int[] list = matrix[listIndex];

            indexes[listIndex] += 1;
            if (indexes[listIndex] == list.length) {
                continue;
            }

            pq.offer(new int[]{list[indexes[listIndex]], listIndex});

        }

        return result;
    }
}
