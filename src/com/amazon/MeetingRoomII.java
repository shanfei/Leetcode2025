package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 * find the max overlap intervals
 */
public class MeetingRoomII {

    public int minMeetingRooms(int[][] intervals) {

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for ( int i = 0; i < intervals.length; ++i ) {
            int[] a = intervals[i];
            starts[i] = a[0];
            ends[i] = a[1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int usedRoom = 0;

        for ( int i = 0, j = 0; i < intervals.length; ++i ) {

            if (starts[i] >= ends[j]) {
                usedRoom--;
                j++;
            }

            usedRoom++;

        }

        return usedRoom;

    }

    public static void main(String[] args) {
        MeetingRoomII m = new MeetingRoomII();

        int[][] p1 = new int[][] {{0,30},{5,10},{15,20}};
        int[][] p2 = new int[][] {{7,10},{2,4}};
        int[][] p3 = new int[][] {{9,10},{4,9},{4,17}};

        List<int[][]> p = List.of (p1, p2, p3 );

        for ( int[][] a : p ) {
            System.out.println(m.minMeetingRooms(a));
        }

    }
}
