package com.designguru.code.pattern.queue.monotonic;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given an integer array nums and an integer limit,
 * return the maximum length of a continuous subarray such that the absolute difference between any two elements in this subarray is less than or equal to limit.
 * The subarray must be non-empty.
 *
 * Examples
 * Example 1:
 *
 * Input: nums = [1, 3, 6, 7, 9, 10], limit = 3
 * Output: 3
 * Explanation: Consider the [6, 7, 9] or [7, 9, 10] array.
 * The absolute difference between any two elements in these subarrays is at most 3.
 * Example 2:
 *
 * Input: nums = [8, 2, 4, 10, 12], limit = 6
 * Output: 3
 * Explanation: The longest subarray is [8, 2, 4].
 * The absolute difference between any two elements in this subarray is at most 6.
 * Example 3:
 *
 * Input: nums = [1, 5, 9, 13, 14], limit = 4
 * Output: 2
 * Explanation: Consider the [1, 5], [5, 9], [9, 13] or [13, 14] array.
 * The absolute difference between any two elements in these subarrays is at most 4.
 *
 *
 */
public class LongestContinuousSubArrayWithAbsoluteDiff {

    // Method to find the length of the longest subarray with an absolute difference less than or equal to limit
    public static int longestSubarray(int[] nums, int limit) {

        int maxLength = 0;

        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();

        for ( int  i = 0, j = 0; j < nums.length; j++ ) {

            int currentElem = nums[j];

            while ( !maxQueue.isEmpty() && currentElem >= nums[maxQueue.peekLast()] ) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(j);

            while (!minQueue.isEmpty() && currentElem <= nums[minQueue.peekLast()]) {
                minQueue.pollLast();
            }
            minQueue.offerLast(j);

            while ( !maxQueue.isEmpty() && !minQueue.isEmpty() &&
                    nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > limit ) {

                i++;

                if (maxQueue.peekFirst() < i) {
                    maxQueue.pollFirst();
                }

                if (minQueue.peekFirst() < i) {
                    minQueue.pollFirst();
                }
            }


            maxLength = Math.max(maxLength, j - i + 1 );

        }

        return maxLength;
    }
}
