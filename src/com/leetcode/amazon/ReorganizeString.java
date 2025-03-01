package com.leetcode.amazon;

/**
 *
 * 767. Reorganize String
 *
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 *
 * Return any possible rearrangement of s or return "" if not possible.
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: s = "aaab"
 * Output: ""
 *
 */
public class ReorganizeString {

    public String reorganizeString(String s) {

        int[] frequencies = new int[26];

        int maxFrequency = 0;
        int maxFrequencyChar = -1;

        for ( char c : s.toCharArray() ) {
            int i = c - 'a';
            frequencies[i]++;

            if ( frequencies[i] > maxFrequency ) {
                maxFrequency = frequencies[i];
                maxFrequencyChar = i;
            }
        }

        if (maxFrequency > ( s.length() + 1 ) / 2) {
            return "";
        }

        char[] l = new char[s.length()];

        int index = 0;

        for (int i = 0; i < maxFrequency && index < l.length;
             i++, index += 2, frequencies[maxFrequencyChar]--) {
            l[index] =  (char)(maxFrequencyChar + 'a');
        }

        for ( int i = 0; i < 26; ++i ) {

            char c = (char) (i + 'a');

            while ( frequencies[i] > 0 ) {

                if (index >= s.length()) {
                    index = 1;
                }

                l[index] = c;
                index =  index + 2;
                frequencies[i]--;
            }

        }

        return new String(l);

    }


    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("aab"));
        System.out.println(reorganizeString.reorganizeString("bfrbs"));
        System.out.println(reorganizeString.reorganizeString("aabb"));
        System.out.println(reorganizeString.reorganizeString("aabbb"));
    }
}
