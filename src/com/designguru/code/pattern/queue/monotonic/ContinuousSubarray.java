package com.designguru.code.pattern.queue.monotonic;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * You are given a 0-indexed array of integers called nums.
 * A subarray of num is called continuous if the following condition is met:
 *
 * consider i, i + 1, ..., j be the indices in the subarray.
 * Then, for each pair of indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2.
 * Return the total number of continuous subarrays within nums.
 *
 * A subarray is defined as any contiguous, non-empty sequence of elements within an array.
 *
 * Examples
 * Example 1:
 *
 * Input: nums = [1, 2, 2, 13, 1]
 * Expected Output: 8
 * Justification: The continuous subarrays are [1], [2], [2], [13], [1], [1, 2], [2, 2], and [1, 2, 2].
 *
 * Example 2:
 *
 * Input: nums = [3, 3, 4, 2]
 * Expected Output: 10
 * Justification: The continuous subarrays are [3], [3], [4], [2], [3, 3], [3, 4], [4, 2], [3, 3, 4], [3, 4, 2], and [3, 3, 4, 2].
 *
 * Example 3:
 *
 * Input: nums = [5, 17, 35, 26, 5]
 * Expected Output: 5
 * Justification: The continuous subarrays are [5], [17], [35], [26], and [5].
 *
 * max queue
 *
 * min queue
 *
 * [i1..i2] => max(i1, i2) = j => maxqueue
 * [i1..i2] => min(i1, i2) = m => minqueue
 *
 *
 *
 */
public class ContinuousSubarray {


    public  int getMaxInSubarray(Deque<Integer> maxQueue) {
        // Return -1 if max queue is empty, otherwise return the first element
        return maxQueue.size() == 0 ? -1 : maxQueue.peekFirst();
    }

    public  int getMinInSubarray(Deque<Integer> minQueue) {
        // Return -1 if min queue is empty, otherwise return the first element
        return minQueue.size() == 0 ? -1 : minQueue.peekFirst();
    }

    public  long continuousSubarrays(int[] nums) {

        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();

        int total = 0;

        for ( int i = 0, j = 0; i < nums.length; ++i) {

            int k = nums[i];

            while ( !maxQueue.isEmpty() && maxQueue.peekLast() < k ) {
                maxQueue.removeLast();
            }

            maxQueue.offerLast(k);

            while ( !minQueue.isEmpty() &&  minQueue.peekLast() > k ) {
                minQueue.removeLast();
            }

            minQueue.offerLast(k);

            while ( getMaxInSubarray(maxQueue) - getMinInSubarray(minQueue) > 2 ) {

                if (!maxQueue.isEmpty() && maxQueue.peekFirst() == nums[j] ) {
                    maxQueue.removeFirst();
                }

                if (!minQueue.isEmpty() && minQueue.peekFirst() == nums[j]) {
                    minQueue.removeFirst();
                }

                j++;

            }

            total += i - j + 1;

        }


        return total;
    }

    public static void main(String[] args) {

        ContinuousSubarray c = new ContinuousSubarray();

        // Test case 1
        int[] nums1 = {1, 2, 2, 13, 1};
        System.out.println("Example 1: " + c.continuousSubarrays(nums1));

        // Test case 2
        int[] nums2 = {3, 3, 4, 2};
        System.out.println("Example 2: " + c.continuousSubarrays(nums2));

        // Test case 3
        int[] nums3 = {5, 17, 35, 26, 5};
        System.out.println("Example 3: " + c.continuousSubarrays(nums3));
    }
}
