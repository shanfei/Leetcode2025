package com.leetcode.amazon.graph;

import java.util.*;

public class CheapestFlightsWithAtMostKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<String , Integer> weights = buildEdgeWeightMap(flights);
        Map<Integer , List<Integer>> adj = buildAdj(flights);


        //TODO
        return -1;

    }

    Map<String , Integer> buildEdgeWeightMap( int[][] flights ) {
        Map<String , Integer> r = new HashMap<>();

        for ( int[] edge : flights ) {
            //r.putIfAbsent(this.buildEdge(edge[0], edge[1]), edge[2]);
        }

        return r;
    }

    Map<Integer, List<Integer>> buildAdj(int[][] flights) {

        Map<Integer, List<Integer>> ret = new HashMap<>();

        for ( int[] edge : flights ) {
            List<Integer> r =  ret.getOrDefault(edge[0], new ArrayList<>());
            r.add(edge[1]);
            ret.put(edge[0], r);
        }

        return ret;


    }

    void bfs(int n, int src, int des, int k, Map<Integer, List<Integer>> adj, Map<String, Integer> weights ) {

        PriorityQueue<int[]> pq = new PriorityQueue<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(src);

        while (!queue.isEmpty()) {

        }

    }

    public static void main(String[] args) {
        int[][] input = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;

        CheapestFlightsWithAtMostKStops a = new CheapestFlightsWithAtMostKStops();
        System.out.println(a.findCheapestPrice(4, input, src, dst, 1));
    }
}
