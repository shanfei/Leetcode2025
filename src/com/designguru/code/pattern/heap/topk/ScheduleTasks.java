package com.designguru.code.pattern.heap.topk;

import java.util.*;

/**
 *
 * You are given a list of tasks that need to be run, in any order, on a server.
 * Each task will take one CPU interval to execute but once a task has finished,
 * it has a cooling period during which it can’t be run again.
 * If the cooling period for all tasks is ‘K’ intervals, find the minimum number of CPU intervals that the server needs to finish all tasks.
 *
 * If at any time the server can’t execute any task then it must stay idle.
 *
 * Example 1:
 *
 * Input: [a, a, a, b, c, c], K=2
 * Output: 7
 * Explanation: a -> c -> b -> a -> c -> idle -> a
 * Example 2:
 *
 * Input: [a, b, a], K=3
 * Output: 5
 * Explanation: a -> b -> idle -> idle -> a
 *
 * Same as
 *
 */
public class ScheduleTasks {

    public int scheduleTasks(char[] tasks, int k) {

        int intervalCount = 0;

        PriorityQueue<Map.Entry<Character, Integer>> frequencyQueue =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        Map<Character, Integer> m = new HashMap<>();

        for (char c : tasks) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            frequencyQueue.offer(entry);
        }


        while (!frequencyQueue.isEmpty()) {

            List<Map.Entry<Character, Integer>> l = new LinkedList<>();

            if (frequencyQueue.peek().getValue() == 1 && frequencyQueue.size() <= k) {
                intervalCount += frequencyQueue.size();
                break;
            }

            // 保持 element的间隔是 K
            for (int i = 0; i <= k; ++i) {
                if (!frequencyQueue.isEmpty()) {
                    Map.Entry<Character, Integer> entry = frequencyQueue.poll();
                    int f = entry.getValue() - 1;
                    m.put(entry.getKey(), f);
                    l.add(entry);
                    intervalCount++;
                } else {
                    intervalCount++;
                }
            }


            for (Map.Entry<Character, Integer> entry : l) {
                if (entry.getValue() > 0) {
                    frequencyQueue.offer(entry);
                }
            }
        }


        return intervalCount;

    }
}
