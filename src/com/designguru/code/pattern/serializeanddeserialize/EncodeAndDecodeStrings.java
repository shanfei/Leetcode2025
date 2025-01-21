package com.designguru.code.pattern.serializeanddeserialize;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Design an algorithm to implement these two functions:
 * one that can effectively convert the list of strings to a single string (encoding)
 * and another that can revert this single string back to the original list (decoding).
 *
 * Constraints:
 *
 * You cannot use any serialization methods such as eval.
 * The goal is to ensure that after encoding and then decoding, the output is identical to the input.
 * Machine 1 (Sender):
 *
 * encode(List<String> strs): Takes a list of strings and converts it to a single encoded string.
 * Machine 2 (Receiver):
 *
 * decode(String s): Takes the encoded string and reconstructs the original list of strings.
 * Ensure that after sending the encoded string from Machine 1 to Machine 2,
 * the list of strings obtained on Machine 2 is exactly the same as the one sent from Machine 1.
 *
 * Examples
 * Example 1:
 *
 * Input: strs = ["dog", "cat", "bird"]
 * Expected Output: ["dog", "cat", "bird"]
 * Justification: The list of strings contains three simple words. The encoded version should accurately store each word,
 * and the decode function should reconstruct the exact original list.
 *
 * Example 2:
 *
 * Input: strs = ["hello,world", "foo!bar", ""]
 * Expected Output: ["hello,world", "foo!bar", ""]
 * Justification: This test case includes strings with special characters like commas and exclamation marks,
 * as well as an empty string. The encoding must handle special characters and empty strings properly without losing any data.
 * Example 3:
 *
 * Input: strs = ["", "", "empty"]
 * Expected Output: ["", "", "empty"]
 * Justification: This test case includes multiple empty strings and a non-empty string.
 * The encoding should differentiate between multiple empty strings and preserve the original order and count of the strings.
 *
 */
public class EncodeAndDecodeStrings {


    // Function to encode a list of strings
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for ( String s : strs ) {
            sb.append(s.length()).append("#");
        }

        return sb.toString();
    }

    // Function to decode the single string back to a list of strings
    public List<String> decode(String s) {

        List<String> strs = new ArrayList<>();

        char[] cs = s.toCharArray();

        for ( int i = 0; i < cs.length;  ) {

            char c = cs[i];

            int length = 0;
            int k = 0;

            while ( Character.isDigit(c) ) {
                length += c + 10 * k++;
                i++;
                c = cs[i];
            }

            if ( c == '#' ) {
                i++;
            }

            strs.add(s.substring(i, i + length));

        }

        return strs;
    }
}
