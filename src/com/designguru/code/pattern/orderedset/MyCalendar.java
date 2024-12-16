package com.designguru.code.pattern.orderedset;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Problem Statement
 * Given a 2D array nums of size N x 2.
 *
 * nums[i] = [starti, endi], where starti is the starting time of the event and endi is the ending time of the event.
 * For each nums[i], determine if a requested booking time conflicts with any existing bookings.
 *
 * Return a boolean array of size N, representing whether the booking can be done in the given time interval.
 *
 * Examples
 * Example 1:
 *
 * Input: nums = [[10, 20], [15, 25], [20, 30]]
 * Expected Output: [true, false, true]
 * Justification: The first event is booked successfully. The second event overlaps with the first one and is rejected. The third event starts when the first event ends, so it's booked successfully.
 * Example 2:
 *
 * Input: [[5, 10], [10, 15], [5, 15]]
 * Expected Output: [true, true, false]
 * Justification: The first and second events are booked without overlap. The third event overlaps with both the first and second, so it's rejected.
 * Example 3:
 *
 * Input: [[8, 13],[13, 17], [17, 20]]
 * Expected Output: [true, true, true]
 * Justification: All events are booked without any overlap, as each event starts exactly when the previous one ends.
 * Constraints:
 *
 * 0 <= start < end <= 109
 * At most 1000 calls will be made to book.
 *
 */

public class MyCalendar {

    public static List<Boolean> book(int[][] nums) {

        List<Boolean> results = new ArrayList<>();



        return results;
    }
}
