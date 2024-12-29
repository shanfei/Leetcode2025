package com.designguru.code.pattern.stack.monotonic;

import java.util.Stack;

/**
 *
 * You are given a string s and an integer k.
 * Your task is to remove groups of identical, consecutive characters from the string such that each group has exactly k characters.
 * The removal of groups should continue until it's no longer possible to make any more removals.
 * The result should be the final version of the string after all possible removals have been made.
 *
 * Examples
 *
 * Input: s = "abbbaaca", k = 3
 * Output: "ca"
 * Explanation: First, we remove "bbb" to get "aaaca". Then, we remove "aaa" to get "ca".
 * Input: s = "abbaccaa", k = 3
 * Output: "abbaccaa"
 * Explanation: There are no instances of 3 adjacent characters being the same.
 * Input: s = "abbacccaa", k = 3
 * Output: "abb"
 * Explanation: First, we remove "ccc" to get "abbaaa". Then, we remove "aaa" to get "abb".
 *
 */
public class RemoveAllAdjacentDuplicatesnStringII {

    public String removeDuplicates(String s, int k) {

        char[] cs = s.toCharArray();

        Stack<int[]> stack = new Stack<>();

        for (char c : cs) {
            if (stack.isEmpty() || stack.peek()[0] != c) {
                stack.push(new int[]{c, 1});
            } else if (stack.peek()[0] == c && stack.peek()[1] == k - 1) {
                stack.pop();
            } else if (stack.peek()[0] == c && stack.peek()[1] < k - 1 ) {
                stack.peek()[1]++;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            int[] c = stack.pop();
            while ( c[1]-- > 0 ) {
                sb.append((char)c[0]);
            }
        }

        return sb.reverse().toString();
    }


}
