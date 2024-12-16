package com.servicenow;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Leetcode 56:
 *
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * merge overlapping intervals
 *
 * step 1: sortBy start asc
 * step 2: if end1 > start2 => merge
 * O(nLog(n))
 * 
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 *
 */
public class MergeInterval {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, ( a, b) -> { return a[0] - b[0] ; });

        List<int[]> mergedIntervals = new ArrayList<>();

        for (int i = 0; i < intervals.length; ++i) {

            if ( mergedIntervals.isEmpty()  ) {
                mergedIntervals.add(intervals[i]);
            } else {
                int[] mergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);
                int[] interval = merge(mergedInterval, intervals[i]);
                if ( interval != null ) {
                    mergedIntervals.add(interval);
                }
            }
        }

        int[][] ret = new int[mergedIntervals.size()][2];

        for ( int i = 0; i < mergedIntervals.size(); ++i ) {
            ret[i] = mergedIntervals.get(i);
        }

        return ret;

    }

    int[] merge(int[] a, int[] b) {
        if ( a[1] >= b[0] ) {
            a[0] = Math.min(a[0], b[0]);
            a[1] = Math.max(a[1], b[1]);
            return null;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {


        MergeInterval intstance = new MergeInterval();

        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        int[][] b = {{1,4},{4,5}};

        int[][] merged = intstance.merge(b);
        System.out.println(merged.length);

        for ( int[] k : merged ) {
            System.out.print(" [ ");
            for (int l : k ) {
                System.out.print( l + "," );
            }
            System.out.print(" ], ");
        }
        System.out.println();
    }
}
