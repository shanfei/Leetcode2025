package com.designguru.code.pattern.topologysort;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Problem Statement
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’.
 * Each task can have some prerequisite tasks which need to be completed before it can be scheduled.
 *
 * Given the number of tasks and a list of prerequisite pairs, find out if it is possible to schedule all the tasks.
 *
 * Examples
 * Example 1:
 *
 * Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
 * Output: true
 * Explanation: A possible scheduling of tasks is: [0 1 4 3 2 5]
 * Example 2:
 *
 * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
 * Output: true
 * Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs to finish before '2' can be scheduled. One possible scheduling of tasks is: [0, 1, 2]
 * Example 3:
 *
 * Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
 * Output: false
 * Explanation: The tasks have a cyclic dependency, therefore they cannot be scheduled.
 *
 * BFS: start from  ( in order is 0 node ) -> add to queue ->  decrease those node's out order, when that node is removed (added to a stack)
 *
 * if any of a visited node found during processing return false
 *
 */
public class TaskSchedule {

    // bfs
    public boolean isSchedulingPossible(int tasks, int[][] prerequisites) {

        int[] inorders = new int[tasks];

        // 1. 计算入度
        for ( int[] p : prerequisites ) {
            int from = p[0];
            int to = p[1];
            inorders[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // 2. 把入度为0的节点加入队列 是 拓扑排序的开始节点
        for ( int i = 0; i < inorders.length; ++i ) {
            int inorder = inorders[i];
            if ( inorder == 0 ) {
                queue.offer(i);
            }
        }

        // 队列里面加入的都是 入度为0 的节点
        List<Integer> sortedList = new ArrayList<>();

        while ( !queue.isEmpty() ) {

            int v = queue.poll();

            for ( int[] e : prerequisites ) {
                int fromV = e[0];
                int toV = e[1];
                if ( fromV == v ) {
                    if (--inorders[toV] == 0) {
                        queue.add(toV);
                    }
                }
            }

            sortedList.add(v);
        }


        return sortedList.size() >= tasks;
    }


}
