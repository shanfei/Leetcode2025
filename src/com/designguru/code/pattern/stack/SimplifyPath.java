package com.designguru.code.pattern.stack;

import java.util.Stack;

/**
 *
 * Given an absolute file path in a Unix-style file system, simplify it by converting ".."
 * to the previous directory and removing any "." or multiple slashes.
 * The resulting string should represent the shortest absolute path.
 *
 * Examples:
 * 1.
 *    Input: "/a//b////c/d//././/.."
 *    Output: "/a/b/c"
 *
 * 2.
 *    Input: "/../"
 *    Output: "/"
 *
 * 3.
 *    Input: "/home//foo/"
 *    Output: "/home/foo"
 *
 */
public class SimplifyPath {

    public String simplifyPath(String path) {

        char[] cs = path.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cs.length; ++i) {

            char state = cs[i];

            char prev = stack.isEmpty() ? ' ' : stack.peek();

            boolean isCharacterOrDigital = Character.isLetterOrDigit(state);

            switch ( state ) {

                case '/':

                    if ( prev != '/' ) {
                        stack.push(state);
                    }

                    break;
                case '.':
                    if ( prev == '/') {

                        while (!stack.isEmpty() && stack.peek() != '/') {
                            stack.pop();
                        }

                        stack.pop();

                        if (i < cs.length - 1 && cs[i + 1] == '.') {
                            while (!stack.isEmpty() && stack.peek() != '/') {
                                stack.pop();
                            }

                            if (!stack.isEmpty()) stack.pop();
                            i++;
                        }
                    }

                    break;

                default:

                    if ( isCharacterOrDigital  ) {
                        stack.push(state);
                    }

                    break;

            }

        }

        StringBuilder sb = new StringBuilder();
        for (Character folder : stack) {
            sb.append(folder);
        }

        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '/') {
            sb.deleteCharAt(sb.length() - 1);
        }  else if (sb.isEmpty()) {
            sb.append("/");
        }

        return sb.toString();
    }

}
