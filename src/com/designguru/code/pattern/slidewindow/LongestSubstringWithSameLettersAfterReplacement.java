package com.designguru.code.pattern.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string with lowercase letters only,
 * if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 *
 */
public class LongestSubstringWithSameLettersAfterReplacement {

    public int findLength(String str, int k) {

        int maxLength = 0;

        char[] cs = str.toCharArray();

        int s = 0;

        Map<Character, Integer> cache = new HashMap<>();

        int maxRepeatCount = 0;

        for (int e = 0; e < cs.length; e++) {

            char c = cs[e];

            cache.put(c, cache.getOrDefault(c, 0) + 1);
            maxRepeatCount = Math.max(maxRepeatCount, cache.get(c));

            while ( isExceedCountLimitK(e, s, maxRepeatCount, k) ) {

                char css = cs[s++];
                cache.put(css, cache.getOrDefault(css,1) - 1);

            }

            maxLength = Math.max(maxLength, e - s + 1);

        }

        return maxLength;
    }

    boolean isExceedCountLimitK(int e, int s, int maxRepeatCount, int k) {
        return e - s + 1 - maxRepeatCount > k;
    }


}
