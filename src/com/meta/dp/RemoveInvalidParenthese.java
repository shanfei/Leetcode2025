package com.meta.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
 *
 * Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 * Example 2:
 *
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 * Example 3:
 *
 * Input: s = ")("
 * Output: [""]
 *
 * (())()
 *
 * if the prev sub is valid then remove any that ')' can make it valid, invalid mim is the num of invlid ')'
 *
 * if a sub is valid and new str is steart with } then is is invvalid ussing a count when ')' then -1, '(' then +1
 *
 * if the r < 0 is the invalid so we also need store the invalid c's index, only work on the substring with
 */
public class RemoveInvalidParenthese {

    public List<String> removeInvalidParentheses(String s) {

        int leftCount = 0, rightCount = 0;
        int validCount = 0;
        int unrelatedCharCount = 0;
        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < s.length(); ++i ) {

            char c = s.charAt(i);

            if ( c == '(' ) {
                leftCount++;
            } else if ( c == ')' ) {
                rightCount++;
                if ( rightCount <= leftCount && leftCount > 0 ) {
                    validCount += 2;
                    rightCount--;
                    leftCount--;
                } else {
                    rightCount--;
                }
            } else {
                unrelatedCharCount++;
                sb.append(c);
            }

        }

        int validTotalCount  = validCount + unrelatedCharCount;


        Set<String> r = new HashSet<>();

        backtrack(s, 0, new StringBuilder(), r, 0,  0, validCount, validTotalCount);

        return r.isEmpty() ? List.of(sb.toString()) : new ArrayList<>(r);

    }

    void backtrack(String s, int currentIndex, StringBuilder sb, Set<String> result, int countLeft, int countRight, int maxCount, int maxStrCount) {

        if (currentIndex == s.length()) {
            if (countRight + countLeft == maxCount && countLeft == countRight && sb.length() == maxStrCount ) {
                result.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(currentIndex);

        if ( c == ')' && countRight == countLeft ) {
            backtrack(s, currentIndex + 1, sb, result, countLeft, countRight, maxCount, maxStrCount);
            return;
        }

        int l =  c == '(' ? countLeft + 1 : countLeft ;
        int r =  c == ')' ? countRight + 1 : countRight;

        sb.append(c);

        backtrack(s, currentIndex + 1, sb, result, l, r, maxCount, maxStrCount);


        sb.deleteCharAt(sb.length() - 1);

        backtrack(s, currentIndex + 1, sb, result, countLeft, countRight, maxCount, maxStrCount);

    }

    public static void main(String[] args) {
        RemoveInvalidParenthese r = new RemoveInvalidParenthese();
        System.out.println(r.removeInvalidParentheses("(a)())()"));
    }


}
