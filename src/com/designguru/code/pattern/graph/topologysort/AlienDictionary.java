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

        List<char[]> wordsCharList = new ArrayList<>();

        for (String w: words) {
            wordsCharList.add(w.toCharArray());
        }

        Integer[] indegreeMapOfChars = new Integer[26];

        int i = 0;

        boolean run = true;

        Map<Integer, Set<Integer>> adjancetMap = new HashMap<>();

        while ( run ) {

            for (int j = 1; j < wordsCharList.size(); ++j) {

                if ( i >= wordsCharList.get(j - 1).length || i >= wordsCharList.get(j).length ) {
                    run = false;
                    break;
                }

                int parent = wordsCharList.get(j - 1)[i] - 'a';
                int child = wordsCharList.get(j)[i] - 'a';

                if (parent != child) {
                    Set<Integer> l = adjancetMap.getOrDefault(parent, new HashSet<>());
                    l.add(child);
                    adjancetMap.put(parent, l);
                }

                if (indegreeMapOfChars[parent] == null) {
                    indegreeMapOfChars[parent] = 0;
                }

                if (indegreeMapOfChars[child] == null) {
                    indegreeMapOfChars[child] = 1;
                } else if (child != parent) {
                    indegreeMapOfChars[child]++;
                }
            }

            i++;
        }


        return bfs(adjancetMap, indegreeMapOfChars);
    }

    static String bfs(Map<Integer, Set<Integer>> adjancetMap,  Integer[] indegreeMapOfChars) {

        List<Integer> l = new ArrayList<>();

        int size = 0;

        for (int i = 0; i < indegreeMapOfChars.length; ++i) {
            Integer indegree = indegreeMapOfChars[i];
            if (indegree != null && indegree == 0) {
                l.add(i);
            }

            if (indegree != null) {
                size++;
            }
        }

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>(l);

        StringBuilder sb = new StringBuilder();

        while ( !queue.isEmpty() ) {

            int i = queue.poll();

            sb.append((char)(i + 'a'));

            visited.add(i);

            Set<Integer> k = adjancetMap.get(i);

           for (int j : k) {

               if (visited.contains(j)) {
                   continue;
               }

               indegreeMapOfChars[j]--;

               if (indegreeMapOfChars[j] == 0) {
                   queue.add(j);
               }
           }

        }

        if (sb.length() != size )
            return "";

        return sb.toString();
    }

    public static void main(String[] args) {

        String[][] p = {
//                {"ba", "bc", "ac", "cab"},
//                {"cab", "aaa", "aab"},
                {"ywx", "wz", "xww", "xz", "zyy", "zwz"}
        } ;

        for (String[] pp : p) {
            System.out.println(findOrder(pp));
        }
    }


}
