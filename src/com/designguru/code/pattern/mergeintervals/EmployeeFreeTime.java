package com.designguru.code.pattern.mergeintervals;

import common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class EmployeeInterval {
    Interval interval; // interval representing employee's working hours
    int employeeIndex; // index of the list containing working hours of this employee
    int intervalIndex; // index of the interval in the employee list

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
};

/**
 *
 * For ‘K’ employees, we are given a list of intervals representing each employee’s working hours.
 * Our goal is to determine if there is a free interval which is common to all employees.
 *
 * Example 1:
 *
 * Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
 * Output: [3,5]
 * Explanation: All the employees are free between [3,5].
 * Example 2:
 *
 * Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
 * Output: [4,6], [8,9]
 * Explanation: All employees are free between [4,6] and [8,9].
 * Example 3:
 *
 * Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
 * Output: [5,7]
 * Explanation: All employees are free between [5,7].
 *
 */
public class EmployeeFreeTime {


    public List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        List<Interval> mergedIntervals = new ArrayList<>();

        for (List<Interval> intervals : schedule) {
            mergedIntervals.addAll(intervals);
        }

        Collections.sort(mergedIntervals, (a, b) -> a.start - b.start);

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> b.end - a.end);

        for (int i = 0; i < mergedIntervals.size(); ++i) {

            if (!pq.isEmpty()) {

                Interval top = pq.peek();

                if ( top.end < mergedIntervals.get(i).start ) {
                    result.add(new Interval(top.end, mergedIntervals.get(i).start));
                } else {
                    pq.poll();
                }
            }

            pq.add(mergedIntervals.get(i));
        }

        return result;
    }

}
