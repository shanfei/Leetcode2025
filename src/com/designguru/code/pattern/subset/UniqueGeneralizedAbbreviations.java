package com.designguru.code.pattern.subset;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a word, write a function to generate all of its unique generalized abbreviations.
 *
 * A generalized abbreviation of a word can be generated by replacing each substring of the word with the count of characters in the substring. Take the example of “ab” which has four substrings: “”, “a”, “b”, and “ab”. After replacing these substrings in the actual word by the count of characters, we get all the generalized abbreviations: “ab”, “1b”, “a1”, and “2”.
 *
 * Note: All contiguous characters should be considered one substring, e.g., we can’t take “a” and “b” as substrings to get “11”; since “a” and “b” are contiguous, we should consider them together as one substring to get an abbreviation “2”.
 *
 * Example 1:
 *
 * Input: "BAT"
 * Output: "BAT", "BA1", "B1T", "B2", "1AT", "1A1", "2T", "3"
 * Example 2:
 *
 * Input: "code"
 * Output: "code", "cod1", "co1e", "co2", "c1de", "c1d1", "c2e", "c3", "1ode", "1od1", "1o1e", "1o2", "2de", "2d1", "3e", "4"
 *
 */
public class UniqueGeneralizedAbbreviations {


    public List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        this.generateAbbreviation(result, word.toCharArray(), 0, new ArrayList<>());
        return result;
    }

    void generateAbbreviation(List<String> result, char[] word, int currentIndex, List<Character> path) {

        if (currentIndex == word.length) {
            StringBuilder sb = new StringBuilder();
            for (char c : path) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        List<Character> candidates = new ArrayList<>();
        candidates.add(word[currentIndex]);

        if (!path.isEmpty() && Character.isDigit(path.get(path.size() - 1))) {
            int k = path.get(path.size() - 1) - '0';
            candidates.add((char)(k + 1 + '0'));
        } else {
            candidates.add('1');
        }

        for (char c : candidates) {

            boolean hasRemove = false;

            if (Character.isDigit(c) && !path.isEmpty() && Character.isDigit(path.get(path.size() - 1)) ) {
                path.remove(path.size() - 1);
                hasRemove = true;
            }

            path.add(c);
            generateAbbreviation(result, word, currentIndex + 1, path);
            if (!hasRemove) {
                path.remove(path.size() - 1);
            }
        }
    }
}
