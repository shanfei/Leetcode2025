package com.leetcode.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * leetcode 2405
 *
 * Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.
 *
 * Return the minimum number of substrings in such a partition.
 *
 * Note that each character should belong to exactly one substring in a partition.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abacaba"
 * Output: 4
 * Explanation:
 * Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
 * It can be shown that 4 is the minimum number of substrings needed.
 * Example 2:
 *
 * Input: s = "ssssss"
 * Output: 6
 * Explanation:
 * The only valid partition is ("s","s","s","s","s","s").
 *
 */
public class OptimalPartitionOfString {

    public int partitionString(String s) {

        char[] cs = s.toCharArray();

        int i = 0, j = 0;

        Set<Character> chs = new HashSet<>();

        int count = 0;

        while ( j < cs.length ) {

            char c = cs[j];

            if ( chs.contains(c)  )  {
                i = j;
                count++;
                chs.clear();
            } else {
                chs.add(c);
                j++;

                if (j == cs.length) {
                    count++;
                }
            }

        }

        return count;

    }
}
