package com.designguru.code.pattern.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * Given an array, print the Next Greater Element (NGE) for every element.
 *
 * The Next Greater Element for an element x is the first greater element on the right side of x in the array.
 *
 * Elements for which no greater element exist, consider the next greater element as -1.
 *
 * Examples
 * Example 1:
 *
 *  Input: [4, 5, 2, 25]
 *  Output: [5, 25, 25, -1]
 * Example 1:
 *
 *  Input: [13, 7, 6, 12]
 *  Output: [-1, 12, 12, -1]
 * Example 1:
 *
 *  Input: [1, 2, 3, 4, 5]
 *  Output: [2, 3, 4, 5, -1]
 *
 */
public class NextGreaterElement {

    public List<Integer> nextLargerElement(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        for (int i = arr.size() - 1; i >= 0; --i) {

            int k = arr.get(i);

            while ( !stack.isEmpty() && stack.peek() <= k ) {
                stack.pop();
            }

            int r = stack.isEmpty() ? -1 : stack.peek();

            stack.push(k);

            res.add(r);
        }

        Collections.reverse(res);

        return res;
    }
}
