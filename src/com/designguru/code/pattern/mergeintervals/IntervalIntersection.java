package com.designguru.code.pattern.mergeintervals;

import common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given two lists of intervals, find the intersection of these two lists.
 * Each list consists of disjoint intervals sorted on their start time.
 *
 * Example 1:
 *
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 * Example 2:
 *
 * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
 * Output: [5, 7], [9, 10]
 * Explanation: The output list contains the common intervals between the two lists.
 *
 */
public class IntervalIntersection {

    public List<Interval> merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {

            Interval i1 = arr1[i];
            Interval i2 = arr2[j];

            // check if one of the interval's start time lies within the other interval
            if (
                    ( i1.start <= i2.start && i1.end >= i2.start ) ||
                            ( i2.start <= i1.start && i2.end >= i1.start )
            ) {
                result.add(new Interval(Math.max(i1.start, i2.start), Math.min(i1.end, i2.end)));
            }


            // move next from the interval which is finishing first
            if (arr1[i].end < arr2[j].end)
                i++;
            else
                j++;

        }



        return result;
    }


}

