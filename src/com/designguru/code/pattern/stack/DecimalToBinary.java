package com.designguru.code.pattern.stack;

import java.util.Stack;

/**
 * Given a positive integer n,
 * write a function that returns its binary equivalent as a string.
 * The function should not use any in-built binary conversion function.
 *
 * Examples
 * Example 1:
 *
 * Input: 2
 * Output: "10"
 * Explanation: The binary equivalent of 2 is 10.
 * Example 2:
 *
 * Input: 7
 * Output: "111"
 * Explanation: The binary equivalent of 7 is 111.
 * Example 3:
 *
 * Input: 18
 * Output: "10010"
 * Explanation: The binary equivalent of 18 is 10010.
 *
 */
public class DecimalToBinary {

    public static String decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();

        while ( num != 0 ) {

            stack.push( String.valueOf(num % 2));
            num = num / 2;

        }

        while ( !stack.isEmpty() ) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }


}
