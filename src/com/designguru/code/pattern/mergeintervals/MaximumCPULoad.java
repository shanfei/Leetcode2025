package com.designguru.code.pattern.mergeintervals;

import common.Job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * We are given a list of Jobs. Each job has a Start time, an End time,
 * and a CPU load when it is running. Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
 *
 * Example 1:
 *
 * Jobs: [[1,4,3], [2,5,4], [7,9,6]]
 * Output: 7
 * Explanation: Since [1,4,3] and [2,5,4] overlap,
 * their maximum CPU load (3+4=7) will be when both the jobs are running at the same time i.e., during the time interval (2,4).
 * Example 2:
 *
 * Jobs: [[6,7,10], [2,4,11], [8,12,15]]
 * Output: 15
 * Explanation: None of the jobs overlap, therefore we will take the maximum load of any job which is 15.
 * Example 3:
 *
 * Jobs: [[1,4,2], [2,4,1], [3,6,5]]
 * Output: 8
 * Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4].
 *
 */
public class MaximumCPULoad {

    public int findMaxCPULoad(List<Job> jobs) {
        int maxCPULoad = 0;

        List<Job> sortedJobs = new ArrayList<>(jobs);

        Collections.sort(sortedJobs, (m1, m2) -> m1.start - m2.start);

        int totalCPULoad = 0;

        for  (int i = 0; i < sortedJobs.size(); ++i) {

            if ( i == 0 || ( !isNonOverlap(sortedJobs.get(i - 1), sortedJobs.get(i) )) ) {
                totalCPULoad += sortedJobs.get(i).cpuLoad;
            } else {
                totalCPULoad = sortedJobs.get(i).cpuLoad;
            }

            maxCPULoad = Math.max(maxCPULoad, totalCPULoad);
        }


        return maxCPULoad;
    }

    boolean isNonOverlap(Job m1, Job m2) {
        return ( m1.end <= m2.start );
    }


}
