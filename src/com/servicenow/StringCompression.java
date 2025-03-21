package com.servicenow;

/**
 *
 * Leetcode 443
 *
 * O(N) time complexity with O(1) space complexity
 *
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately,
 * but instead, be stored in the input character array chars.
 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 *
 * You must write an algorithm that uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 * Example 2:
 *
 * Input: chars = ["a"]
 * Output: Return 1, and the first character of the input array should be: ["a"]
 * Explanation: The only group is "a", which remains uncompressed since it's a single character.
 * Example 3:
 *
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 *
 */
public class StringCompression {

    public int compress(char[] chars) {


        int i = 0;

        int totalCount = 0;

        int n = 0;

        while ( i < chars.length ) {

            char ch = chars[i];

            int j = i;
            int gl = 1;

            while ( ++j < chars.length && chars[j] == ch ) {
               gl++;
            }

            chars[n++] = ch;
            int l = 0;

            if ( gl > 1 ) {
                for (char c : Integer.toString(gl).toCharArray()) {
                    chars[n++] = c;
                    l++;
                }
            }

            if ( gl <= 1 ) {
                totalCount += 1 ;
            } else {
                totalCount += l + 1;
            }

            i = j;

        }

        return totalCount;

    }

    public static void main(String[] args) {
        StringCompression instance = new StringCompression();
        System.out.println(instance.compress( new char[]{ 'a','a','b','b','c','c','c' } ));
        System.out.println(instance.compress( new char[]{ 'a' } ));
        System.out.println(instance.compress( new char[]{ 'a','b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'} ));
    }
}
