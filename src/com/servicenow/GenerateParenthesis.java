package com.servicenow;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * leetcode 22
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 * 1. 组合问题 指数级别 时间复杂度
 * 2. 使用 递归
 *
 * 30 min
 *
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        generateParenthesis(n , result, new StringBuilder(), 0, 0);

        return result;

    }

    void generateParenthesis(int n, List<String> result, StringBuilder sb, int count1, int count2 ) {

        if ( count1 == n && count2 == n ) {
            result.add(sb.toString());
            return;
        }

        if (count2 > count1) {
            return;
        }

        if (count1 < n) {

            sb.append('(');
            count1++;
            generateParenthesis(n, result, sb, count1, count2);
            count1--;
            sb.deleteCharAt(sb.length() - 1);
        }

        if  (count2 < n) {
            sb.append(')');
            count2++;
            generateParenthesis(n, result, sb, count1, count2);
            count2--;
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        GenerateParenthesis instance = new GenerateParenthesis();
        List<String> s = instance.generateParenthesis(1);
        for (String ss : s) {
            System.out.print(ss + " : " );
        }
        System.out.println();
    }
}
