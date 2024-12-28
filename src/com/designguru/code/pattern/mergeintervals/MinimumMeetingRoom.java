package com.designguru.code.pattern.mergeintervals;

import common.Meeting;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * Given a list of intervals representing the start and end time of ‘N’ meetings,
 * find the minimum number of rooms required to hold all the meetings.
 *
 * Example 1:
 *
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can occur in any of the two rooms later.
 * Example 2:
 *
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
 * Example 3:
 *
 * Meetings: [[1,4], [2,3], [3,6]]
 * Output:2
 * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to hold all the meetings.
 * Example 4:
 *
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
 *
 *
 */
public class MinimumMeetingRoom {

    public int findMinimumMeetingRooms(List<Meeting> meetings) {

        Collections.sort(meetings, (m1, m2) -> m1.start - m2.start);

        PriorityQueue<Meeting> pq = new PriorityQueue<>((m1, m2) -> m1.end - m2.end);

        for (Meeting meeting : meetings) {

            Meeting meetingWithMinEndTime = pq.peek();

            if ( meetingWithMinEndTime != null ) {
                if ( isNonOverlap(meeting, meetingWithMinEndTime) ) {
                    pq.poll();
                }
            }

            pq.add(meeting);

        }


        return pq.size();
    }

    boolean isNonOverlap(Meeting m1, Meeting m2) {
        return ( m2.end <= m1.start );
    }

}
