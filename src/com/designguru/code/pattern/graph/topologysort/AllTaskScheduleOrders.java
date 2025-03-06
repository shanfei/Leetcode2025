package com.designguru.code.pattern.graph.topologysort;

import java.util.*;

/**
 *
 * Problem Statement
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled.
 *
 * Given the number of tasks and a list of prerequisite pairs, write a method to print all possible ordering of tasks meeting all prerequisites.
 *
 * Examples
 * Example 1:
 *
 * Input: Tasks=4, Prerequisites=[3, 2], [3, 0], [2, 0], [2, 1]
 * Output:
 * 1) [3, 2, 0, 1]
 * 2) [3, 2, 1, 0]
 * Explanation: There are two possible orderings of the tasks meeting all prerequisites.
 * Example 2:
 *
 * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
 * Output: [0, 1, 2]
 * Explanation: There is only possible ordering of the tasks.
 * Example 3:
 *
 * Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
 * Output:
 * 1) [0, 1, 4, 3, 2, 5]
 * 2) [0, 1, 3, 4, 2, 5]
 * 3) [0, 1, 3, 2, 4, 5]
 * 4) [0, 1, 3, 2, 5, 4]
 * 5) [1, 0, 3, 4, 2, 5]
 * 6) [1, 0, 3, 2, 4, 5]
 * 7) [1, 0, 3, 2, 5, 4]
 * 8) [1, 0, 4, 3, 2, 5]
 * 9) [1, 3, 0, 2, 4, 5]
 * 10) [1, 3, 0, 2, 5, 4]
 * 11) [1, 3, 0, 4, 2, 5]
 * 12) [1, 3, 2, 0, 5, 4]
 * 13) [1, 3, 2, 0, 4, 5]
 *
 * toplogic sort with backtrack
 *
 * combination + toplogic sort
 *
 */
public class AllTaskScheduleOrders {


    public List<List<Integer>> printOrders(int tasks, int[][] prerequisites) {

        List<List<Integer>> result = new ArrayList<>();

        if (tasks <= 0 ) {
            return result;
        }

        int[] inorderMap = buildInorderMap(tasks);

        Map<Integer, List<Integer>> adjList = adj(inorderMap,prerequisites);



        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < inorderMap.length; ++i) {
            if (inorderMap[i] == 0) {
                q.offer(i);
            }
        }

        toplogicSort(inorderMap, q,  adjList,  new ArrayList<>(),  result, tasks);

        return result;
    }

    int mapTaskIdToIndex(int i) {
        return i;
    }

    Map<Integer, List<Integer>> adj(int[] inorderMap, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for ( int[] p : prerequisites ) {

            int k = p[0];
            int v = p[1];

            List<Integer> l =  map.getOrDefault(k, new ArrayList<>());
            l.add(v);
            map.put(k,l);

            inorderMap[mapTaskIdToIndex(v)]++;
        }

        return map;
    }

    int[] buildInorderMap(int tasks) {
        return new int[tasks];
    }

    void toplogicSort(int[] inorderMap,  Queue<Integer> q, Map<Integer, List<Integer>> adjList, List<Integer> path, List<List<Integer>> result, int tasks) {

        if (path.size() == tasks) {
            result.add(new ArrayList<>(path));
        }

        if (!q.isEmpty()) {

            for (Integer node : q) {

                path.add(node);

                Queue<Integer> clone = cloneQueue(q);
                clone.remove(node);

                if (adjList.get(node) != null) {
                    for (int nb : adjList.get(node)) {
                        inorderMap[mapTaskIdToIndex(nb)]--;
                        if (inorderMap[mapTaskIdToIndex(nb)] == 0) {
                            clone.offer(nb);
                        }
                    }
                }

                toplogicSort(inorderMap, clone, adjList, path, result, tasks);

                path.remove(path.size() - 1);

                if (adjList.get(node) != null) {
                    for (int nb : adjList.get(node)) {
                        inorderMap[mapTaskIdToIndex(nb)]++;
                    }
                }
            }


        }
    }

    Queue<Integer> cloneQueue(Queue<Integer> q) {
        return new LinkedList<>(q);
    }


    public static void main(String[] args) {

        AllTaskScheduleOrders sol = new AllTaskScheduleOrders();

        List<List<Integer>> result1 = sol.printOrders(4, new int[][] { new int[] { 3, 2 },
                new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println("Topological orders for tasks 2:");
        for (List<Integer> order : result1) {
            System.out.println(order);
        }

        List<List<Integer>> result2 = sol.printOrders(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Topological orders for tasks 1:");
        for (List<Integer> order : result2) {
            System.out.println(order);
        }

        List<List<Integer>> result3 = sol.printOrders(6,
                new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                        new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Topological orders for tasks 3:");
        for (List<Integer> order : result3) {
            System.out.println(order);
        }



    }
}
