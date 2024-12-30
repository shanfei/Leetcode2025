package com.designguru.code.pattern.counting;

/**
 *
 * You are given an array of integers nums. In a single move,
 * you can pick any index i, where 0 <= i < nums.length and add 1 to nums[i].
 *
 * Return the minimum number of moves to make all elements in the nums unique.
 *
 * Examples
 *
 * Example 1
 * Input: nums = [4, 3, 2, 2, 1, 4]
 * Output: 5
 * Explanation: We need 1 move to increment the 4 at index 5 to 5,
 * and then 4 moves to increment the 2 at index 4 to 6. So, we need total 5 moves.
 *
 * Example 2
 * Input: nums =  [5, 5, 5, 5, 5]
 * Output: 10
 * Explanation: Increment each subsequent 5 to get [5, 6, 7, 8, 9], needing 10 moves.
 *
 * Example 3
 * Input: nums =  [1, 1, 1, 1, 2]
 * Output: 9
 * Explanation: Increment three of the 1s to get [1, 2, 3, 4, 2] with 1 + 2 + 3 = 6 moves, then increment the second 2 to 5 to get [1, 2, 3, 4, 5] with 3 moves, needing total 9 moves.
 *
 */
public class MinimumIncrementToMakeArrayUnique {

    public static int minIncrementForUnique(int[] nums) {

        int max = 0;

        for ( int n : nums ) {
            if ( max < n ) {
                max = n;
            }
        }

        int[] frequencyArray = new int[max + nums.length];

        for ( int n : nums ) {
            frequencyArray[n]++;
        }

        int steps = 0;

        for ( int i = 0; i < frequencyArray.length; ++i ) {

            if (frequencyArray[i] < 2) {
                continue;
            }

            frequencyArray[i + 1] += frequencyArray[i] - 1;
            steps += frequencyArray[i] - 1;

        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{4, 3, 2, 2, 1, 4})); // Output: 5
        System.out.println(minIncrementForUnique(new int[]{5, 5, 5, 5, 5}));    // Output: 10
        System.out.println(minIncrementForUnique(new int[]{1, 1, 1, 1, 2}));
    }
}
