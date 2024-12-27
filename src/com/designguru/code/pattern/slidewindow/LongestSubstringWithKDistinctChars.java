package com.designguru.code.pattern.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChars {

    public int findLength(String str, int k) {

        int maxLength = 0;

        char[] cs = str.toCharArray();
        Map<Character,Integer> cache = new HashMap<>();
        int distinctCount = 0;
        int s = 0;

        for (int e = 0; e < cs.length; ++e) {

            char c = cs[e];

            int cc = cache.getOrDefault(c, 0);

            if (cc == 0) {
                distinctCount++;
            }

            cache.put(c, cc + 1);

            while (s < e && distinctCount > k) {

                char sc = cs[s++];

                int scc = cache.get(sc);

                if ( --scc == 0) {
                    distinctCount--;
                }

                cache.put(sc, scc);
            }



            maxLength = Math.max(maxLength, e - s + 1);

        }


        return maxLength;
    }
}
