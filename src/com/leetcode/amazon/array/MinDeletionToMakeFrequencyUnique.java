package com.leetcode.amazon.array;

import java.util.Arrays;

public class MinDeletionToMakeFrequencyUnique {

    public int minDeletions(String s) {

        Integer[] a = new Integer[26];

        Arrays.fill(a, 0);

        for (char c : s.toCharArray()) {
            a[(int) c - 'a']++;
        }

        Arrays.sort(a, (i, j) -> {
            return j - i;
        });

        int deletions = 0;

        for ( int i = 1; i < 26; ++i ) {

            if (a[i] == 0) continue;

            int k = a[i - 1];
            int p = a[i];

            if ( p >= k ) {

                int desiredFrequency = Math.max(0, k - 1); // Calculating the desired frequency to make it unique
                deletions += p - desiredFrequency; // Calculating deletions needed
                a[i] = desiredFrequency; //

            }

        }

        return deletions;
    }
}
