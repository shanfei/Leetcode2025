package com.designguru.code.pattern.stack;

/**
 *
 * Given a string, write a function that uses a stack to reverse the string. The function should return the reversed string.
 *
 * Examples
 * Example 1:
 *
 * Input: "Hello, World!"
 * Output: "!dlroW ,olleH"
 * Example 2:
 *
 * Input: "OpenAI"
 * Output: "IAnepO"
 * Example 3:
 *
 * Input: "Stacks are fun!"
 * Output: "!nuf era skcatS"
 *
 */
public class ReverseString {

    public String reverseString(String s) {
        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length / 2; ++i) {
            char tmp = cs[i];
            cs[i] = cs[cs.length - i - 1];
            cs[cs.length - i - 1] = tmp;
        }

        return new String(cs);
    }

}
