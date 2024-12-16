package com.designguru.code.pattern.orderedset;


import java.util.Stack;
import java.util.TreeSet;

/**
 *
 * Problem Statement
 * Given an array nums, containing N integers.
 *
 * A 132 pattern consists of three numbers, say x, y, and z, where x < z and z < y.
 * This is often referred to as a '132' pattern because if we represent x, y, and z as 1, 3, and 2,
 * respectively, it mimics the positional pattern in '132'.
 *
 * Return true if such a pattern exists within any sequence of given numbers nums. Otherwise, return false.
 *
 * Examples
 * Example 1:
 *
 * Input: nums = [3, 5, 0, 3, 4]
 * Expected Output: True
 * Justification: Here, 3 < 4 and 4 < 5, forming a '132' pattern with the numbers 3, 5, and 4.
 * Example 2:
 *
 * Input: nums = [1, 2, 3, 4]
 * Expected Output: False
 * Justification: The sequence is in ascending order, and no '132' pattern is present.
 * Example 3:
 *
 * Input: nums = [9, 11, 8, 9, 10, 7, 9]
 * Expected Output: True
 * Justification: The pattern is formed with 8 < 9 and 9 < 10 in sequence 8, 10, 9.
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 2 * 105
 * -109 <= nums[i] <= 109
 *
 */
public class OneThreeTwoPattern {

    // Method to check if the array contains a 132 pattern
    public static boolean find132pattern(int[] nums) {

        // 1. use a stack to maintain the order of index
        Stack<Integer> stack = new Stack<>();

        // 2. use a TreeSet to maintain order of numbers
        TreeSet<Integer> treeSet = new TreeSet<>();

        int l = nums.length;

        for (int i = l - 1; i >= 0; i--) {

            int n = nums[i];

            while ( !stack.isEmpty() && stack.peek() < n ) {
                treeSet.add(stack.pop());
            }

            if ( !stack.isEmpty() && !treeSet.isEmpty() ) {
                Integer next = treeSet.higher(n);
                if ( next != null ) {
                    return true;
                }
            }

            stack.push(n);
        }

        return false;
    }

    public static void main(String[] args) {
       System.out.println( find132pattern(new int[]{3, 5, 0, 3, 4}));
    }

}
