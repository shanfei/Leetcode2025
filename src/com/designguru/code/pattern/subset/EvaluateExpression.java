package com.designguru.code.pattern.subset;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given an expression containing digits and operations (+, -, *), find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
 *
 * Example 1:
 *
 * Input: "1+2*3"
 * Output: 7, 9
 * Explanation:
 *   1+(2*3) => 7
 *   (1+2)*3 => 9
 * Example 2:
 *
 * Input: "2*3-4-5"
 * Output: 8, -12, 7, -7, -3
 * Explanation:
 *   2*(3-(4-5)) => 8
 *   2*(3-4-5) => -12
 *   2*3-(4-5) => 7
 *   2*(3-4)-5 => -7
 *   (2*3)-4-5 => -3
 *
 *
 */
public class EvaluateExpression {

    public List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();

        if (input.length() == 1) {
            char c = input.charAt(0);
            result.add(c - '0');
            return result;
        }


        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);

            if (!Character.isDigit(c)) {

                String left = input.substring(0, i);
                String right = input.substring(i + 1);

                List<Integer> leftResults = diffWaysToEvaluateExpression(left);
                List<Integer> rightResults = diffWaysToEvaluateExpression(right);

                for (int l : leftResults) {
                    for (int r : rightResults) {
                        result.add(evaludate(l, r, c));
                    }
                }

            }

        }

        return result;
    }

    int evaludate(int num1, int num2, char op) {

        switch (op) {
            case '*' :
                return num1 * num2;
            case '/' :
                return num1 / num2;
            case '+' :
                return num1 + num2;
            case '-' :
                return num1 - num2;
            default:
                return 0;
        }

    }
}
