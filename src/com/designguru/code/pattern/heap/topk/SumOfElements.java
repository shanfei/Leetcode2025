package com.designguru.code.pattern.heap.topk;

import java.util.PriorityQueue;

/**
 *
 * Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.
 *
 * Example 1:
 *
 * Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
 * Output: 23
 * Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum of numbers coming
 * between 5 and 15 is 23 (11+12).
 * Example 2:
 *
 * Input: [3, 5, 8, 7], and K1=1, K2=4
 * Output: 12
 * Explanation: The sum of the numbers between the 1st smallest number (3) and the 4th smallest
 * number (8) is 12 (5+7).
 *
 */
public class SumOfElements {

    public int findSumOfElements(int[] nums, int k1, int k2) {

        int elementSum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
        }

        int d =  k1;

        while ( !pq.isEmpty() && d-- > 0 ) {
            pq.poll();
        }

        d = k2 - k1;

        while ( !pq.isEmpty() && d-- > 1 ) {
            elementSum += pq.poll();
        }

        return elementSum;
    }

}
