package com.designguru.code.pattern.graph.topologysort;


import java.util.*;

/**
 *
 * Problem Statement
 *
 * There is a dictionary containing words from an alien language for which we don’t know the ordering of the letters.
 *
 * Given a list of strings words from the alien language's dictionary. All strings in words are sorted lexicographically by the rules of this new language.
 *
 * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules.
 *
 * It is given that the input is a valid dictionary and there exists an ordering among its letters.
 *
 * Example 1:
 *
 * Input: Words: ["ba", "bc", "ac", "cab"]
 * Output: bac
 * Explanation: Given that the words are sorted lexicographically by the rules of the alien language, so
 * from the given words we can conclude the following ordering among its characters:
 *
 * 1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
 * 2. From "bc" and "ac", we can conclude that 'b' comes before 'a'
 *
 * From the above two points, we can conclude that the correct character order is: "bac"
 * Example 2:
 *
 * Input: Words: ["cab", "aaa", "aab"]
 * Output: cab
 * Explanation: From the given words we can conclude the following ordering among its characters:
 *
 * 1. From "cab" and "aaa", we can conclude that 'c' comes before 'a'.
 * 2. From "aaa" and "aab", we can conclude that 'a' comes before 'b'
 *
 * From the above two points, we can conclude that the correct character order is: "cab"
 * Example 3:
 *
 * Input: Words: ["ywx", "wz", "xww", "xz", "zyy", "zwz"]
 * Output: ywxz
 * Explanation: From the given words we can conclude the following ordering among its characters:
 *
 * 1. From "ywx" and "wz", we can conclude that 'y' comes before 'w'.
 * 2. From "wz" and "xww", we can conclude that 'w' comes before 'x'.
 * 3. From "xww" and "xz", we can conclude that 'w' comes before 'z'
 * 4. From "xz" and "zyy", we can conclude that 'x' comes before 'z'
 * 5. From "zyy" and "zwz", we can conclude that 'y' comes before 'w'
 *
 * From the above five points, we can conclude that the correct character order is: "ywxz"
 *
 * 1. 从 words 构建 邻接表
 * 2. 对于 领接表 做 拓扑排序
 *
 */
public class AlienDictionary {

    public static String findOrder(String[] words) {

        Map<Integer, Set<Integer>> adj = buildAdj(words);

        Map<Integer, Integer> indegreeMap = buildIndegreeMap(words, adj);

        return toplogicSort(adj, indegreeMap);

    }

    static String toplogicSort(Map<Integer, Set<Integer>> adj,  Map<Integer, Integer> indegreeMap) {

        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        for ( Map.Entry<Integer, Integer> e : indegreeMap.entrySet() ) {
            if ( e.getValue() == 0 ) {
                q.offer(e.getKey());
            }
        }

        while (!q.isEmpty()) {

            int n = q.poll();

            sb.append((char)(n + 'a'));

            Set<Integer> nbs = adj.getOrDefault(n, new HashSet<>());

            for ( int nb : nbs ) {

                indegreeMap.put(nb, indegreeMap.get(nb)-1);

                if ( indegreeMap.get(nb) == 0 ) {
                    q.offer(nb);
                }
            }
        }

        if ( sb.length() != indegreeMap.size() ) {
            return "";
        }


        return sb.toString();


    }

    static Map<Integer, Set<Integer>> buildAdj(String[] words) {

        Map<Integer, Set<Integer>> adj = new HashMap<>();

        for (String word : words) {
            for (char character : word.toCharArray()) {
                adj.put(character - 'a', new HashSet<>());
            }
        }

        for ( int i = 0; i < words.length - 1; ++i ) {

            String w = words[i];
            String nw = words[i + 1];

            if (w.contains(nw)) {
                continue;
            }

            for ( int j = 0; j < w.length() && j < nw.length(); ++j ) {

                int c1 = w.charAt(j) - 'a';
                int c2 = nw.charAt(j) - 'a';

                if ( c1 != c2 ) {
                    Set<Integer> nbs = adj.getOrDefault(c1, new HashSet<>());
                    nbs.add(c2);
                    adj.put(c1, nbs);
                    break;
                }
            }

        }

        return adj;
    }

    static Map<Integer, Integer> buildIndegreeMap(String[] words, Map<Integer, Set<Integer>> adj) {

        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for (String word : words) {
            for (char character : word.toCharArray()) {
                indegreeMap.put(character - 'a', 0);
            }
        }

        for ( int key : adj.keySet() ) {

            Set<Integer> nbs = adj.get(key);

            for (int nb : nbs) {
                indegreeMap.put(nb, indegreeMap.getOrDefault(nb, 0) + 1);
            }
        }

        return indegreeMap;

    }



    public static void main(String[] args) {

        AlienDictionary sol = new AlienDictionary();
        String result = sol.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = sol.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = sol.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }


}
