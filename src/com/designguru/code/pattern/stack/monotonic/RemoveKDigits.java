package com.designguru.code.pattern.stack.monotonic;

import java.util.Stack;

/**
 *
 * Given a non-negative integer represented as a string num and an integer k,
 * delete k digits from num to obtain the smallest possible integer.
 * Return this minimum possible integer as a string.
 *
 * Examples
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: The digits removed are 4, 3, and 2 forming the new number 1219 which is the smallest.
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Removing the leading 1 forms the smallest number 200.
 *
 *
 * Input: num = "1901042", k = 4
 * Output: "2"
 * Explanation: Removing 1, 9, 1, and 4 forms the number 2 which is the smallest possible. Constraints:
 *
 * "1425678" k = 3
 *
 *
 */
public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {

        Stack<Integer> mstack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < num.length(); ++i ) {

            int c = num.charAt(i) - '0';

            while ( k > 0 && !mstack.isEmpty() && mstack.peek() > c ) {
                mstack.pop();
                k--;
            }

            mstack.push(c);

        }

        while ( !mstack.isEmpty() && k > 0 ) {
            mstack.pop();
            k--;
        }

        boolean isLeadingZero = true;

        for ( int i : mstack ) {

            if (isLeadingZero && i != 0) {
                isLeadingZero = false;
            } else if (isLeadingZero) {
                continue;
            }

            sb.append(i);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3)); // Output: "1219"
        System.out.println(removeKdigits("10200", 1)); // Output: "200"
        System.out.println(removeKdigits("1901042", 4));
    }

}
