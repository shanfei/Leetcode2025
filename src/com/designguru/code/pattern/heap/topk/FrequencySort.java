package com.designguru.code.pattern.heap.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * Given a string, sort it based on the decreasing frequency of its characters.
 *
 * Example 1:
 *
 * Input: "Programming"
 * Output: "rrggmmPiano"
 * Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.
 *
 * Example 2:
 *
 * Input: "abcbab"
 * Output: "bbbaac"
 * Explanation: 'b' appeared three times, 'a' appeared twice, and 'c' appeared only once.
 *
 */
public class FrequencySort {

    public String sortCharacterByFrequency(String str) {

        char[] chars = str.toCharArray();

        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : chars) {
            frequency.put(c,frequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue =
                new PriorityQueue<>( (a, b) ->  b.getValue() - a.getValue()  );

        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            queue.offer(entry);
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            result.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }

        return result.toString();
    }
}
