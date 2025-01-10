package com.designguru.code.pattern.heap.twoheaps;

import common.Interval;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * Given an array of intervals, find the next interval of each interval. In a list of intervals, for an interval ‘i’ its next interval ‘j’ will have the smallest ‘start’ greater than or equal to the ‘end’ of ‘i’.
 *
 * Write a function to return an array containing indices of the next interval of each input interval. If there is no next interval of a given interval, return -1. It is given that none of the intervals have the same start point.
 *
 * Example 1:
 *
 * Input: Intervals [[2,3], [3,4], [5,6]]
 * Output: [1, 2, -1]
 * Explanation: The next interval of [2,3] is [3,4] having index ‘1’. Similarly, the next interval of [3,4] is [5,6] having index ‘2’. There is no next interval for [5,6] hence we have ‘-1’.
 * Example 2:
 *
 * Input: Intervals [[3,4], [1,5], [4,6]]
 * Output: [2, -1, -1]
 * Explanation: The next interval of [3,4] is [4,6] which has index ‘2’. There is no next interval for [1,5] and [4,6].
 *
 */
public class NextInterval {

    public static int[] findNextInterval(Interval[] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        // min end heap
        PriorityQueue<Interval> maxEndHeap = new PriorityQueue<Interval>( (p1, p2 )  -> {
            return p2.end - p1.end;
        });

        // max start heap
        PriorityQueue<Interval> maxStartHeap = new PriorityQueue<Interval>( ( p1, p2 ) -> {
            return p2.start - p1.start;
        });

        Map<Interval, Integer> map = new HashMap<>();

        for ( int i = 0; i < n; i++ ) {
            Interval interval = intervals[i];
            maxEndHeap.offer(interval);
            maxStartHeap.offer(interval);
            map.put(interval, i);
        }

        while ( !maxEndHeap.isEmpty() ) {

            Interval interval = maxEndHeap.poll();
            int currentIndex = map.get(interval);

            Interval nextInterval = null;

            while ( !maxStartHeap.isEmpty()  ) {
                if ( maxStartHeap.peek().start < interval.end ) {
                    break;
                } else {
                    nextInterval = maxStartHeap.poll();
                }
            }

            result[currentIndex] = nextInterval == null ? -1 : map.get(nextInterval);

        }

        return result;
    }
}
