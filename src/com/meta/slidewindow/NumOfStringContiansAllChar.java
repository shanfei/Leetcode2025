package com.meta.slidewindow;

public class NumOfStringContiansAllChar {

    public int numberOfSubstrings(String s) {

        int i = 0, j = 0;

        int[] count = {0, 0, 0};

        int maxLength = 0;

        while (j < s.length()) {

            char c = s.charAt(j);

            count[c - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[c - 'a']--;
                i++;
            }

            maxLength += i;

            j++;

        }

        return maxLength;
    }
}
