package com.designguru.code.pattern.tree.tire;

import common.TrieTree;

import java.util.List;

/**
 *
 * Given a string s and an array of words words.
 * Break string s into multiple non-overlapping substrings such that each substring should be part of the words.
 * There are some characters left which are not part of any substring.
 *
 * Return the minimum number of remaining characters in s, which are not part of any substring after string break-up.
 *
 * Examples
 * Example 1:
 *
 * Input: s = "amazingracecar", words = ["race", "car"]
 * Expected Output: 7
 * Justification: The string s can be rearranged to form "racecar", leaving 'a', 'm', 'a', 'z', 'i', 'n', 'g' as extra.
 * Example 2:
 *
 * Input: s = "bookkeeperreading", words = ["keep", "read"]
 * Expected Output: 9
 * Justification: The words "keep" and "read" can be formed from s, but 'b', 'o', 'o', 'k', 'e', 'r', 'i', 'n', 'g' are extra.
 * Example 3:
 *
 * Input: s = "thedogbarksatnight", words = ["dog", "bark", "night"]
 * Expected Output: 6
 * Justification: The words "dog", "bark", and "night" can be formed, leaving 't', 'h', 'e', 's', 'a', 't' as extra characters.
 *
 */
public class ExtraCharInAString {

    public int minExtraChar(String s, List<String> dictionary) {

        TrieTree trieTree = new TrieTree();

        for (String w : dictionary) {
            trieTree.insert(w);
        }

        int c = 0;

        char[] cs = s.toCharArray();

        for (int i = 0; i < s.length(); ) {

            List<Integer> endIndexes = trieTree.searchSubstr(i, cs);

            if (endIndexes.isEmpty()) {
                i++;
            } else {
                int lastEndIndex = endIndexes.get(endIndexes.size() - 1);
                c += lastEndIndex - i + 1;
                i = lastEndIndex;
            }
        }

        return s.length() - c;
    }

}
