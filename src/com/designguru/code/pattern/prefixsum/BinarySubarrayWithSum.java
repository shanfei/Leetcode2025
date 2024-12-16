package com.designguru.code.pattern.prefixsum;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * Problem Statement
 *
 * Given a binary called nums and an integer called goal, return the number of subarrays that have a sum equal to goal.
 *
 * A subarray is a part of the array that is continuous, meaning all its elements are next to each other.
 *
 * Examples
 * Example 1
 * Input: nums = [1, 1, 0, 1, 1], goal = 2
 * Expected Output: 5
 * Justification: The subarrays with a sum of 3 are: [1, 1] (from index 0 to 1), [1, 1, 0] (from index 0 to 2), [1, 0, 1]
 *  (from index 1 to 3), [0, 1, 1] (from index 2 to 5), and [1, 1] (from index 4 to 5).
 * Example 2
 * Input: nums = [1, 1, 1, 1, 0, 0], goal = 3
 * Expected Output: 4
 * Justification: The subarrays with a sum of 3 are: [1, 1, 1] (from index 0 to 2), [1, 1, 1]
 *  (from index 1 to 3), [1, 1, 1, 0] (from index 1 to 4), and [1, 1, 1, 0, 0] (from index 1 to 5).
 * Example 3
 * Input: nums = [0, 0, 0, 0, 1, 0, 1], goal = 1
 * Expected Output: 12
 * Justification: The subarrays with a sum of 1 are: [0, 0, 0, 0, 1], [0, 0, 0, 1], [0, 0, 1], [0, 1], [1], [0, 0, 0, 0, 1, 0], [0, 0, 0, 1, 0], [0, 0, 1, 0], [0, 1, 0], [1, 0], [0, 1],
 * nd [1]`.
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * nums[i] is either 0 or 1.
 * 0 <= goal <= nums.length
 *
 */
public class BinarySubarrayWithSum {

    public static int numSubarraysWithSum(int[] nums, int goal) {

        int count = 0; // Initialize count of subarrays

        int culSum = 0;

        Map<Integer, Integer> m = new HashMap<>();

        m.put(0, 1);

        for ( int i = 0; i < nums.length; ++i ) {

            culSum += nums[i];

            int r = culSum - goal;
            if (m.get(r) != null) {
                count += m.get(r);
            }

            m.put(culSum, m.getOrDefault(culSum, 0) + 1 );
        }


        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[] {1, 1, 0, 1, 1}, 2));
        System.out.println(numSubarraysWithSum(new int[] {1, 1, 1, 1, 0, 0}, 3));
        System.out.println(numSubarraysWithSum(new int[] {0, 0, 0, 0, 1, 0, 1}, 1));
    }

}


