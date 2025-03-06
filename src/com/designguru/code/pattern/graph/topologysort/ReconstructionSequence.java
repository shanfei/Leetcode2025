package com.designguru.code.pattern.graph.topologysort;

import java.util.*;

/**
 *
 * Given a sequence originalSeq and an array of sequences,
 * write a method to find if originalSeq can be uniquely reconstructed from the array of sequences.
 *
 * Unique reconstruction means that we need to
 * find if originalSeq is the only sequence such that all sequences in the array are subsequences of it.
 *
 * Example 1:
 *
 * Input: originalSeq: [1, 2, 3, 4], seqs: [[1, 2], [2, 3], [3, 4]]
 * Output: true
 * Explanation: The sequences [1, 2], [2, 3], and [3, 4] can uniquely reconstruct
 * [1, 2, 3, 4], in other words, all the given sequences uniquely define the order of numbers
 * in the 'originalSeq'.
 * Example 2:
 *
 * Input: originalSeq: [1, 2, 3, 4], seqs: [[1, 2], [2, 3], [2, 4]]
 * Output: false
 * Explanation: The sequences [1, 2], [2, 3], and [2, 4] cannot uniquely reconstruct
 * [1, 2, 3, 4]. There are two possible sequences we can construct from the given sequences:
 * 1) [1, 2, 3, 4]
 * 2) [1, 2, 4, 3]
 * Example 3:
 *
 * Input: originalSeq: [3, 1, 4, 2, 5], seqs: [[3, 1, 5], [1, 4, 2, 5]]
 * Output: true
 * Explanation: The sequences [3, 1, 5] and [1, 4, 2, 5] can uniquely reconstruct
 * [3, 1, 4, 2, 5].
 *
 *
 */
public class ReconstructionSequence {

    public boolean canConstruct(int[] originalSeq, int[][] sequences) {

        if ( originalSeq.length == 1 && sequences.length == 1 ) {
            return originalSeq.length == sequences[0].length && originalSeq[0] == sequences[0][0];
        }

        Map<Integer, Integer> counts = buildIndegreeMap(sequences);
        Map<Integer, List<Integer>> adj = buildAdj(sequences);

        return toplogicSort(originalSeq, counts, adj);

    }

    boolean toplogicSort(int[] originalSeq, Map<Integer, Integer> counts, Map<Integer, List<Integer>> adj) {

        List<Integer> sortedOrder = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for ( Map.Entry<Integer, Integer> e : counts.entrySet() ) {
            if ( e.getValue() == 0 ) {
                q.offer(e.getKey());
            }
        }

        if ( originalSeq.length != counts.size() ) {
            return false;
        }


        while ( !q.isEmpty() ) {

            // more than one sources mean, there is more than one way to
            if (q.size() > 1) {
                return false;
            }

            int n = q.poll();


            if ( originalSeq[sortedOrder.size()] != n ) {
                return false;
            }

            sortedOrder.add(n);

            List<Integer> nbs = adj.get(n);

            for ( int nb : nbs ) {

                counts.put(nb, counts.get(nb) - 1);

                if ( counts.get(nb) == 0 ) {
                    q.offer(nb);
                }
            }
        }

        return sortedOrder.size() == originalSeq.length;
    }

    Map<Integer, Integer> buildIndegreeMap(int[][] seq) {

        Map<Integer, Integer> m = new HashMap<>();
        for ( int[] s : seq ) {
            for ( int i = 0; i < s.length - 1; ++i ) {
                int a = s[i];
                int b = s[i + 1];
                m.put(a, m.getOrDefault(a,0));
                m.put(b, m.getOrDefault(b,0) + 1);
            }
        }

        return m;
    }

    Map<Integer, List<Integer>> buildAdj(int[][] seq) {

        Map<Integer, List<Integer>> m = new HashMap<>();
        for ( int[] s : seq ) {
            for ( int i = 0; i < s.length - 1; ++i ) {
                int a = s[i];
                int b = s[i + 1];

                m.putIfAbsent(b, new ArrayList<>());

                List<Integer> l = m.getOrDefault(a, new ArrayList<>());
                l.add(b);
                m.put(a, l);
            }
        }

        return m;
    }

   public static void main(String[] args) {
       ReconstructionSequence sol = new ReconstructionSequence();

       boolean result = sol.canConstruct(new int[] { 1 }, new int[][]{{1}});
       System.out.println("Can we uniquely construct the sequence: " + result);


       result = sol.canConstruct(new int[] { 1, 2, 3, 4 },
               new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
       System.out.println("Can we uniquely construct the sequence: " + result);

       result = sol.canConstruct(new int[] { 1, 2, 3, 4 },
               new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
       System.out.println("Can we uniquely construct the sequence: " + result);

       result = sol.canConstruct(new int[] { 3, 1, 4, 2, 5 },
               new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
       System.out.println("Can we uniquely construct the sequence: " + result);
   }

}
