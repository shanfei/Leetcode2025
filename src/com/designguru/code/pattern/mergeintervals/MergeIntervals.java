package com.designguru.code.pattern.mergeintervals;

import common.Interval;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
 *
 * Example 1:
 *
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].
 *
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<>();

        //sort by start of interval
        Collections.sort( intervals , (a, b) -> a.start - b.start);

        for (int i = 0; i < intervals.size(); ) {

            int start = intervals.get(i).start;
            int end = intervals.get(i).end;

            while ( i < intervals.size() - 1 ) {

                if ( intervals.get(i + 1).start > end ) break;

                end = Math.max(end, intervals.get(i + 1).end);
                i++;

            }

            mergedIntervals.add(new Interval(start, end));
            i++;

        }


        return mergedIntervals;
    }
}
