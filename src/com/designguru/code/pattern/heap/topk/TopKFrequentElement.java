package com.designguru.code.pattern.heap.topk;

import java.util.*;

/**
 *
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 *
 * Example 1:
 *
 * Input: [1, 3, 5, 12, 11, 12, 11], K = 2
 * Output: [12, 11]
 * Explanation: Both '11' and '12' apeared twice.
 * Example 2:
 *
 * Input: [5, 12, 11, 3, 11], K = 2
 * Output: [11, 5] or [11, 12] or [11, 3]
 * Explanation: Only '11' appeared twice, all other numbers appeared once.
 *
 */
public class TopKFrequentElement {

    public List<Integer> findTopKFrequentNumbers(int[] nums, int k) {

        List<Integer> topNumbers = new ArrayList<>(k);

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num,frequency.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>( (a, b) ->  b.getValue() - a.getValue()  );

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            queue.offer(entry);
        }

        for (int i = 0; i < k ; ++i) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            if (entry != null) {
                topNumbers.add(entry.getKey());
            }
        }

        return topNumbers;
    }


}
