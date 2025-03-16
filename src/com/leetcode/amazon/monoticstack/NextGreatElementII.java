package com.leetcode.amazon.monoticstack;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * Given a circular integer array nums, return the array containing the next greater number for each element in nums.
 *
 * A next greater number of a number num is the first greater number than the current number in its traversing-order in the array, which means you could search circularly to find its next greater number.
 * If the next greater element doesn't exist, return -1 for the particular number number.
 *
 * Examples
 *
 * Example 1:
 *
 * Input: nums = [2, 1, 2, 4, 3]
 * Expected Output: [4, 2, 4, -1, 4]
 * Justification: For 2, the next greater number is 4. For 1, it's 2 (the next number in the array).
 * For the second 2, 4 is again the next greater. For 4, there's no greater number, hence -1.
 * For 3, looping over, 4 is the next greater number.
 *
 * Example 2:
 *
 * Input: nums = [1, 5, 3, 6, 4]
 * Expected Output: [5, 6, 6, -1, 5]
 * Justification: The next greater for 1 is 5, for 5 is 6, for 3 is 6 again, and for 6 there's no greater number (-1). For 4, considering the circular nature, 5 is the next greater number.
 *
 * Example 3:
 *
 * Input: nums = [9, 8, 7, 3, 2, 1, 6]
 * Expected Output: [-1, 9, 9, 6, 6, 6, 9]
 * Justification: For 9, as it's the greatest, no number is greater, so -1.
 * For 8 and 7, 9 is the next greater number. For 3, 2, and 1, the next greater number is 6, considering the circular array. For 6, 9 is the next greater number by looping over.
 *
 *
 */
public class NextGreatElementII {

    // Function to find the next greater element for each element in the circular array
    public int[] nextGreaterElements(int[] nums) {

        int N = nums.length;
        Stack<Integer> ms = new Stack<>();

        int[] r = new int[N];
        Arrays.fill(r, -1);

        for ( int i = 0; i < N * 2 ;  ++i ) {
            int n = nums[i % N];

            while ( !ms.isEmpty() && nums[ms.peek()] < n ) {
                r[ms.pop()] = n;
            }

            if (n < N) {
                ms.push(i);
            }
        }

        return r;
    }


}
