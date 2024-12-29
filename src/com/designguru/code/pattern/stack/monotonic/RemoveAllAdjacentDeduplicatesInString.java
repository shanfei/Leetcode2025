package com.designguru.code.pattern.stack.monotonic;

import java.util.Stack;

/**
 *
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 *
 * Examples
 *
 * Input: s = "abccba"
 * Output: ""
 * Explanation: First, we remove "cc" to get "abba". Then, we remove "bb" to get "aa". Finally, we remove "aa" to get an empty string.
 * Input: s = "foobar"
 * Output: "fbar"
 * Explanation: We remove "oo" to get "fbar".
 * Input: s = "fooobar"
 * Output: "fobar"
 * Explanation: We remove the pair "oo" to get "fobar".
 * Input: s = "abcd"
 * Output: "abcd"
 * Explanation: No adjacent duplicates so no changes.
 *
 */
public class RemoveAllAdjacentDeduplicatesInString {

    public String removeDuplicates(String s) {

        char[] cs = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cs.length; ++i) {

            char t = cs[i];

            if (!stack.isEmpty() && stack.peek() == t) {
                stack.pop();
                continue;
            }

            stack.push(t);

        }

        char[] a = new char[stack.size()];

        for (int i = a.length - 1; i >= 0; --i) {
            a[i] = stack.pop();
        }

        return new String(a);
    }

}
