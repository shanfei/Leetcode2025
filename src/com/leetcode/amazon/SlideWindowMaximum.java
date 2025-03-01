package com.leetcode.amazon;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * 239. Sliding Window Maximum
 *
 * You are given an array of integers nums,
 * there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * dequeue [3,1,-1]
 * dequeue [5,1,-1]
 * dequeue [5,3,1]
 * dequeue [6,5,3]
 * dequeue [7,6,3]
 *
 */
public class SlideWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 1) return nums;

        Deque<Integer> queue = new LinkedList<>();

        int[] ret = new int[nums.length - k + 1];

        for ( int i = 0, j = 0; i < nums.length; ++i  ) {

            int c = nums[i];

            if ( queue.isEmpty()  ) {

                queue.offerFirst(c);

            } else {

                while (!queue.isEmpty() && queue.peekLast() < c) {
                    queue.pollLast();
                }

                queue.offerLast(c);

                if (i >= k - 1) {
                    ret[j++] = queue.peekFirst();
                }
            }
        }

        return ret;

    }

    public static void main(String[] args) {
        SlideWindowMaximum s = new SlideWindowMaximum();

        int[] l = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ret = s.maxSlidingWindow(l, k);

        for (int r  : ret) {
            System.out.print(r + " ");
        }

        System.out.println();

    }
}
