package com.designguru.code.pattern.heap.topk;

import java.util.*;

/**
 *
 * Given a string and a number ‘K’,
 * find if the string can be rearranged such that the same characters are at least ‘K’ distance apart from each other.
 *
 * Example 1:
 *
 * Input: "mmpp", K=2
 * Output: "mpmp" or "pmpm"
 * Explanation: All same characters are 2 distance apart.
 * Example 2:
 *
 * Input: "Programming", K=3
 * Output: "rgmPrgmiano" or "gmringmrPoa" or "gmrPagimnor" and a few more
 * Explanation: All same characters are 3 distance apart.
 * Example 3:
 *
 * Input: "aab", K=2
 * Output: "aba"
 * Explanation: All same characters are 2 distance apart.
 * Example 4:
 *
 * Input: "aappa", K=3
 * Output: ""
 * Explanation: We cannot find an arrangement of the string where any two 'a' are 3 distance apart.
 *
 */
public class RearrangeStringKElementApart {

    public String reorganizeString(String str, int k) {

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(entry);
        }

        Queue<Map.Entry<Character, Integer>> l = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            Map.Entry<Character, Integer> entry = pq.poll();

            sb.append(entry.getKey());
            int f = entry.getValue() - 1;
            frequencyMap.put(entry.getKey(), f);
            l.offer(entry);

            if ( l.size() == k ) {
                Map.Entry<Character,Integer> e = l.poll();
                if ( e.getValue() > 0 ) {
                    pq.offer(e);
                }
            }
        }

        return sb.length() == str.length() ? sb.toString() : "";
    }

}
