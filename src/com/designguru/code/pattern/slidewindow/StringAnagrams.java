package com.designguru.code.pattern.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 * Every anagram is a permutation of a string. As we know,
 * when we are not allowed to repeat characters while finding permutations of a string,
 * we get N! permutations (or anagrams) of a string having NN characters.
 * For example, here are the six anagrams of the string “abc”:
 *
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 *
 *
 */
public class StringAnagrams {

    public List<Integer> findStringAnagrams(String str, String pattern) {

        List<Integer> resultIndices = new ArrayList<>();

        Map<Character, Integer> map = patternMap(pattern);

        for ( int s = 0; s < str.length(); ++s ) {

            char c = str.charAt(s);

            if ( map.containsKey(c) ) {

                int foundCount = map.size();

                Map<Character, Integer> m = new HashMap<>();

                int e = s;

                while ( e < str.length() && e - s + 1 <= pattern.length() ) {

                    char ec = str.charAt(e);

                    if ( !map.containsKey(ec) || m.getOrDefault(ec, 0) + 1 > map.get(ec) ) break;

                    m.put(ec, m.getOrDefault(ec, 0) + 1);

                    if ( m.get(ec).equals(map.get(ec)) ) {
                        foundCount--;
                    }

                    if ( foundCount == 0 ) {
                        resultIndices.add(s);
                    }

                    e++;

                }
            }

        }

        return resultIndices;
    }

    Map<Character, Integer> patternMap(String pattern) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;

    }

}
