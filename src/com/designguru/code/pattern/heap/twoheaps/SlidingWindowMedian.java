package com.designguru.code.pattern.heap.twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array.
 *
 * Example 1:
 *
 * Input: nums=[1, 2, -1, 3, 5], k = 2
 * Output: [1.5, 0.5, 1.0, 4.0]
 * Explanation: Let's consider all windows of size ‘2’:
 *
 * [1, 2, -1, 3, 5] -> median is 1.5
 * [1, 2, -1, 3, 5] -> median is 0.5
 * [1, 2, -1, 3, 5] -> median is 1.0
 * [1, 2, -1, 3, 5] -> median is 4.0
 *
 * Example 2:
 *
 * Input: nums=[1, 2, -1, 3, 5], k = 3
 * Output: [1.0, 2.0, 3.0]
 * Explanation: Let's consider all windows of size ‘3’:
 *
 * [1, 2, -1, 3, 5] -> median is 1.0
 * [1, 2, -1, 3, 5] -> median is 2.0
 * [1, 2, -1, 3, 5] -> median is 3.0
 *
 *
 */
public class SlidingWindowMedian {

    public double[] findSlidingWindowMedian(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];

        // min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int count = k;
        int n = 0;
        int ii = 0;
        Integer l = nums[ii];

        for ( int i = 0; i < nums.length + 1; i++ ) {

            if ( count == 0 ) {

                result[n] = findMedianOfHeap(minHeap, maxHeap);
                ++n;


                //remove element from heap
                if (!maxHeap.isEmpty() && l <= maxHeap.peek()) {
                    maxHeap.remove(l);
                }

                if (!minHeap.isEmpty() && l >= minHeap.peek()) {
                    minHeap.remove(l);
                }

                rebalance(maxHeap, minHeap);

                l = nums[++ii];

                count++;
            }

            if ( i == nums.length ) {
                break;
            }

            insertNumIntoHeap(nums[i], minHeap, maxHeap);
            count--;

        }

        return result;
    }

    public void rebalance( PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

        while ( minHeap.size() > maxHeap.size() + 1 ) {
            maxHeap.offer(minHeap.poll());
        }

        while ( maxHeap.size() > minHeap.size() + 1 ) {
            minHeap.offer(maxHeap.poll());
        }

    }

    public double findMedianOfHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

        int min = minHeap.isEmpty() ? 0 : minHeap.peek();
        int max = maxHeap.isEmpty() ? 0 : maxHeap.peek();

        if ( maxHeap.size() != minHeap.size() ) {
            return maxHeap.size() > minHeap.size() ? max : min;
        }

        return (double) ( min + max ) / 2;
    }

    public void insertNumIntoHeap(int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

        if ( maxHeap.isEmpty() || num <= maxHeap.peek() ) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // 平衡 最大 最小堆
        while ( maxHeap.size() > minHeap.size() + 1 ) {
            minHeap.offer(maxHeap.poll());
        }

        // 平衡 最大 最小堆
        while ( minHeap.size() > maxHeap.size() + 1 ) {
            maxHeap.offer(minHeap.poll());
        }

    }

}
