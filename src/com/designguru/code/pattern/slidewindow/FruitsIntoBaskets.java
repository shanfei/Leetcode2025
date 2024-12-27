package com.designguru.code.pattern.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {

    public int findLength(char[] arr) {
        int maxLength = 0;

        int k = 2;

        Map<Character, Integer> cache = new HashMap<>();
        int s = 0;
        int dc = 0;

        for (int e = 0; e < arr.length; ++e) {
            char c = arr[e];

            int cc = cache.getOrDefault(c, 0);

            if (cc == 0) {
                dc++;
            }

            cache.put(c, cc + 1);

            while (s < e && dc > k) {

                char sc = arr[s++];

                int scc = cache.get(sc);

                if (--scc == 0) {
                    dc--;
                }

                cache.put(sc, scc);

            }

            maxLength = Math.max(maxLength, e - s + 1);
        }

        return maxLength;
    }
}
