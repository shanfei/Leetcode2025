package com.meta.graph.topologicsort;

import java.util.*;

public class AlienOrder {

    public String alienOrder(String[] words) {

        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        if ( !buildAdj(words, adjList, counts)) return "";

        return toplogicSort(adjList, counts);

    }

    boolean buildAdj(String[] words,  Map<Character, List<Character>> adjList, Map<Character, Integer> counts) {

        // Step 1: Find all edges.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return false;
            }

            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        return true;
    }

    String toplogicSort(Map<Character, List<Character>> adj, Map<Character, Integer> counts) {
        return bfs(adj, counts);
    }

    String bfs(Map<Character, List<Character>> adj, Map<Character, Integer> counts) {

        Queue<Character> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for ( Character c : counts.keySet() ) {
            if (counts.get(c).equals(0)) {
                q.offer(c);
            }
        }

        while (!q.isEmpty()) {

            char c = q.poll();
            sb.append(c);

            List<Character> ns = adj.get(c);

            for ( char cc : ns ) {
                counts.put(cc, counts.get(cc) - 1);
                if ( counts.get(cc) == 0 ) {
                    q.offer(cc);
                }
            }
        }

        if (sb.length() < counts.size()) {
            return "";
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        AlienOrder a = new AlienOrder();

        System.out.println(a.alienOrder(new String[] {"wrt","wrf","er","ett","rftt"}));
    }
}
