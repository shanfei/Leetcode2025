package com.designguru.code.pattern.subset;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
 *
 * Example 1:
 *
 * Input: N=2
 * Output: (()), ()()
 * Example 2:
 *
 * Input: N=3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 *
 */
public class BalancedParentheses {

    public List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();

        generateValidParentheses(result, 0, 0 ,0, num, new ArrayList<>());

        return result;
    }

    public void generateValidParentheses(List<String> result, int c1, int c2,  int i, int num, List<Character> s) {

        if ( s.size() == num * 2) {
            StringBuilder sb = new StringBuilder();
            for (char c : s) {
                sb.append(c);
            }
            result.add(sb.toString());
        }

        if (c2 > c1) {
            return;
        }


        for (int k = i; k < num * 2; ++k) {

            if (c1 < num) {
                s.add('(');
                c1++;

                generateValidParentheses(result, c1, c2, k + 1, num, s);

                s.remove(s.size() - 1);
                c1--;
            }

            if (c2 < num) {
                s.add(')');
                c2++;

                generateValidParentheses(result, c1, c2, k + 1,  num, s);

                s.remove(s.size() - 1);
                c2--;
            }

        }

    }
}
