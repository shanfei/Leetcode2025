package com.designguru.code.pattern.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Given a string and a list of words,
 * find all the starting indices of substrings in the given string that are a concatenation of all the given words exactly once without any overlapping of words.
 * It is given that all words are of the same length.
 *
 * Example 1:
 *
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 * Example 2:
 *
 * Input: String="catcatfoxfox", Words=["cat", "fox"]
 * Output: [3]
 * Explanation: The only substring containing both the words is "catfox".
 *
 */
public class WordsConcatenation {

    public List<Integer> findWordConcatenation(String str, String[] words) {

        List<Integer> resultIndices = new ArrayList<Integer>();

        int lengthOfWordInDict = words[0].length();

        Map<String, Integer> dict = new HashMap<>();

        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }

        for (int s = 0; s < str.length(); s++) {

            Map<String, Integer> visited = new HashMap<>();

            int e = s + lengthOfWordInDict;
            int i = s;

            int totalCount = words.length;

            while ( e <= str.length() && totalCount > 0) {

                String word = str.substring(i, e);

                // found
                if (!dict.containsKey(word)) break;

                Integer count = dict.get(word);
                visited.put(word, visited.getOrDefault(word, 0) + 1);

                if (visited.get(word) > count) {
                    break;
                }

                i = e;
                e = i + lengthOfWordInDict;
                totalCount--;
            }

            if (totalCount == 0) {
                resultIndices.add(s);
            }
        }

        return resultIndices;
    }


}
