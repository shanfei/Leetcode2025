package com.designguru.code.pattern.sort.linear;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * The answer should be sorted by the frequency of the words from highest to lowest.
 * If multiple words have the same frequency, sort them in lexicographical order.
 *
 * Examples
 * Example 1
 * Input: words = ["apple", "banana", "apple", "orange", "banana", "apple"], k = 2
 * Expected Output: ["apple", "banana"]
 * Justification: "apple" appears 3 times, "banana" appears 2 times, and "orange" appears once. Since k is 2, we return the two most frequent words: "apple" and "banana".
 *
 * Example 2
 * Input: words = ["dog", "cat", "mouse", "cat", "dog", "dog"], k = 1
 * Expected Output: ["dog"]
 * Justification: "dog" appears 3 times, "cat" appears 2 times, and "mouse" appears once. Since k is 1, we return the most frequent word: "dog".
 *
 * Example 3
 * Input: words = ["hello", "world", "hello", "coding", "hello", "world"], k = 3
 * Expected Output: ["hello", "world", "coding"]
 * Justification: "hello" appears 3 times, "world" appears 2 times, and "coding" appears once. Since k is 3, we return the three most frequent words: "hello", "world", and "coding".
 *
 */
public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        // ToDo: Write Your Code Here.
        return result;
    }

}
