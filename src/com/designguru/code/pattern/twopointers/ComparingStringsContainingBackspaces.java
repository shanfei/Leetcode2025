package com.designguru.code.pattern.twopointers;

import java.util.Stack;

/**
 *
 * Problem Statement
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 *
 * Example 1:
 *
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 * Example 2:
 *
 * Input: str1="xy#z", str2="xyz#"
 * Output: false
 * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 * Example 3:
 *
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 * Example 4:
 *
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 *
 */
public class ComparingStringsContainingBackspaces {

    public static boolean compare(String str1, String str2) {

        int i = 0, j = 0;

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        while ( i < str1.length() && j < str2.length() ) {

            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);

            if (c1 == '#'  ) {
                if (!s1.isEmpty()) s1.pop();
                i++;
                continue;
            }

            if (c2 == '#' ) {

                if (!s2.isEmpty())   s2.pop();
                j++;
                continue;
            }

            s1.push(c1);
            s2.push(c2);

            i++;
            j++;

        }

        while (i < str1.length()) {
            char c1 = str1.charAt(i);
            if (c1 == '#') {
                if (!s1.isEmpty()) s1.pop();
                i++;
                continue;
            }

            s1.push(c1);
            i++;
        }

        while (j < str2.length()) {
            char c2 = str2.charAt(j);
            if (c2 == '#' ) {
                if (!s2.isEmpty()) s2.pop();
                j++;
                continue;
            }

            s2.push(c2);
            j++;
        }

        if (s1.size() != s2.size()) {
            return false;
        }

        while (!s1.isEmpty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }

        return true;
    }

}
