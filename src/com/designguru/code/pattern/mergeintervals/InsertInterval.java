package com.designguru.code.pattern.mergeintervals;

import common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a list of non-overlapping intervals sorted by their start time,
 * insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
 *
 * Example 1:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 * Example 2:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
 * Output: [[1,3], [4,12]]
 * Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
 * Example 3:
 *
 * Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
 * Output: [[1,4], [5,7]]
 * Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].
 *
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        int start = newInterval.start;
        int end = newInterval.end;

        for ( int i = 0; i < intervals.size(); ++i ) {
            int s = intervals.get(i).start;
            int e = intervals.get(i).end;

            if ( newInterval.start <= e ) {
                start = Math.min(s, start);
            } else {
                mergedIntervals.add(new Interval(s, e));
            }

            if ( newInterval.end >= s ) {
                end = Math.max(e, end);
            } else {
                mergedIntervals.add(new Interval(s, e));
            }

        }

        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }

}
