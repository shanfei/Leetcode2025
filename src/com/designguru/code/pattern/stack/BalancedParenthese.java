package com.designguru.code.pattern.stack;

import java.util.Map;
import java.util.Stack;

/**
 *
 * Given a string s containing (, ), [, ], {, and } characters. Determine if a given string of parentheses is balanced.
 *
 * A string of parentheses is considered balanced if every opening parenthesis has a corresponding closing parenthesis in the correct order.
 *
 * Example 1:
 *
 * Input: String s = "{[()]}";
 * Expected Output: true
 * Explanation: The parentheses in this string are perfectly balanced. Every opening parenthesis '{', '[', '(' has a corresponding closing parenthesis '}', ']', ')' in the correct order.
 *
 * Example 2:
 *
 * Input: string s = "{[}]";
 * Expected Output: false
 * Explanation: The brackets are not balanced in this string. Although it contains the same number of opening and closing brackets for each type, they are not correctly ordered. The ']' closes '[' before '{' can be closed by '}', and similarly, '}' closes '{' before '[' can be closed by ']'.
 *
 * Example 3:
 *
 * Input: String s = "(]";
 * Expected Output: false
 * Explanation: The parentheses in this string are not balanced. Here, ')' does not have a matching opening parenthesis '(', and similarly, ']' does not have a matching opening bracket '['.
 *
 */
public class BalancedParenthese {

    public static Map<Character, Character> pairMap = Map.of('(', ')', '{', '}', '[', ']');

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] cs = s.toCharArray();

        for (char c : cs) {

            if ( !stack.isEmpty() ) {

                char top = stack.peek();

                if ( c == pairMap.getOrDefault(top, ' ')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }

            } else {
                stack.push(c);
            }

        }

        return stack.isEmpty();
    }
}
