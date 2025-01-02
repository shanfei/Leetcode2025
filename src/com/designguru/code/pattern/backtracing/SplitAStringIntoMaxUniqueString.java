package com.designguru.code.pattern.backtracing;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given a string s, return the maximum number of unique substrings that the given string can be split into.
 *
 * You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 2
 * Explanation: Two possible ways to split the given string into maximum unique substrings are: ['a', 'ab'] & ['aa', 'b'], both have 2 substrings; hence the maximum number of unique substrings in which the given string can be split is 2.
 * Example 2:
 *
 * Input: s = "abcabc"
 * Output: 4
 * Explanation: Four possible ways to split into maximum unique substrings are: ['a', 'b', 'c', 'abc'] & ['a', 'b', 'cab', 'c'] &  ['a', 'bca', 'b', 'c'] & ['abc', 'a', 'b', 'c'], all have 4 substrings.
 *
 */
public class SplitAStringIntoMaxUniqueString {

    public int maxUniqueSplit(String s) {
        return maxUniqueSplit(s, 0, new HashSet<>());
    }

    int maxUniqueSplit(String s, int i, Set<String> p) {

        if (i >= s.length()) {
            return p.size();
        }

        int count = 0;

        for ( int endIndex = i + 1; endIndex <= s.length(); ++endIndex ) {
            String substr =  s.substring( i, endIndex);
            if ( !p.contains( substr ) ) {
                p.add(substr);
                count = Math.max(count, maxUniqueSplit(s, endIndex,  p));
                p.remove(substr);
            }
        }

        return count;
    }
}

