package com.designguru.code.pattern.heap.topk;

import java.util.PriorityQueue;

/**
 *
 * Design a class to efficiently find the Kth largest element in a stream of numbers.
 *
 * The class should have the following two things:
 *
 * The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
 * The class should expose a function add(int num) which will store the given number and return the Kth largest number.
 * Example 1:
 *
 * Input: [3, 1, 5, 12, 2, 11], K = 4
 * 1. Calling add(6) should return '5'.
 * 2. Calling add(13) should return '6'.
 * 2. Calling add(4) should still return '6'.
 *
 */
public class KthLargestNumInStream {

    int[] nums;
    int k;

    PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> a - b );

    public KthLargestNumInStream( int[] nums, int k ) {

        this.nums = nums;
        this.k = k;

        for ( int i = 0; i < nums.length; i++ ) {
            if ( i < k ) {
                pq.offer(nums[i]);
            } else {
                this.add(nums[i]);
            }
        }
    }

    public int add(int num) {

        if ( !pq.isEmpty() && pq.peek() < num ) {
            pq.poll();
            pq.offer(num);
        }

        return pq.peek();
    }


}
