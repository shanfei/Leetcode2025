package com.designguru.code.pattern.graph;

import java.util.*;

/**
 *
 * Given a directed acyclic graph with n nodes labeled from 0 to n-1,
 * determine the smallest number of initial nodes such that you can access all the nodes by traversing edges.
 * Return these nodes.
 *
 * find those inorder is 0 nodes
 *
 */
public class MinNumsOfVsToReachAllNotes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        List<Integer> result = new ArrayList<>();

        Map<Integer, List<Integer>> m = new HashMap<>();

        for (List<Integer> edge : edges) {

            List<Integer> a =  m.getOrDefault(edge.get(0), new ArrayList<>());
            a.add(edge.get(1));
            m.put(edge.get(0), a);

        }

        int[] ll = new int[n];

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int k : m.keySet()) {

            if (visited.contains(k)) {
                ll[k] = 1;
            }

            q.offer(k);

            while (!q.isEmpty()) {

                int f = q.poll();

                if (visited.contains(f)) {
                    ll[f] = 1;
                    continue;
                }

                List<Integer> ls = m.get(f);

                if (ls == null) {
                    ll[f] = 1;
                    continue;
                }

                for ( int mn : ls) {

                    q.offer(mn);

                }

                visited.add(f);

            }

        }

        for ( int i = 0; i < n; i++) {
            if (ll[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }

}
