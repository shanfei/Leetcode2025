package com.designguru.code.pattern.mergeintervals;

import common.Interval;

import java.util.Arrays;

/**
 *
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
 *
 * Example 1:
 *
 * Appointments: [[1,4], [2,5], [7,9]]
 * Output: false
 * Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 * Example 2:
 *
 * Appointments: [[6,7], [2,4], [13, 14], [8,12], [45, 47]]
 * Output: true
 * Explanation: None of the appointments overlap, therefore a person can attend all of them.
 * Example 3:
 *
 * Appointments: [[4,5], [2,3], [3,6]]
 * Output: false
 * Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
 *
 */
public class ConflictAppointment {

    public static boolean canAttendAllAppointments(Interval[] intervals) {

        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }

        return true;
    }

}
