package com.meta.dp;

import java.util.*;


/**
 *
 * 126. Word Ladder II
 *
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList,
 * return all the shortest transformation sequences from beginWord to endWord,
 * or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 *
 * hit:hot:lot:dot:log:
 *
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 * //TODO: need add cache to backtrack
 */
public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        TreeMap<Integer, List<List<String>>> ret = new TreeMap<>();

        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }

        Set<String> dict = new HashSet<>(wordList);

        dict.add(beginWord);
        dict.add(endWord);

        Map<String, List<String>> adj = buildAdj(dict);

        List<String> path = new ArrayList<>();

        path.add(beginWord);

        backtrack(beginWord, endWord, 0, adj, new HashSet<>(), path, ret);

        return ret.isEmpty() ? new ArrayList<>() : ret.firstEntry().getValue();

    }

    private  void backtrack(String source, String destination, int level, Map<String, List<String>> adjList, Set<String> visited, List<String> currPath, TreeMap<Integer, List<List<String>>> ret)  {

        // store the path if we reached the endWord
        if (source.equals(destination) ) {

            List<String> tempPath = new ArrayList<>(currPath);

            List<List<String>> list = ret.getOrDefault(level, new ArrayList<>());

            list.add(tempPath);

            ret.put(level, list);

            return;
        }

        if (!adjList.containsKey(source) || visited.contains(source)) {
            return;
        }

        visited.add(source);

        for (String nb: adjList.get(source)) {
            currPath.add(nb);
            backtrack(nb, destination,level + 1, adjList,visited, currPath, ret);
            currPath.remove(currPath.size() - 1);
        }

        visited.remove(source);
    }


    Map<String, List<String>> buildAdj(Set<String> adj) {

        Map<String, List<String>> ret = new HashMap<>();

        for ( String s : adj ) {
            ret.putIfAbsent(s, new ArrayList<>());
        }

        for ( String s : adj ) {
            for ( String k : ret.keySet() ) {
                if ( s.equals(k) ) continue;
                if ( editDistanceIsOne(s, k) ) {

                    // add for both vertex
                    List<String> nbs = ret.get(k);
                    nbs.add(s);
                    ret.put(k, nbs);
                }
            }
        }

        return ret;
    }


    boolean editDistanceIsOne( String s1, String s2 ) {

        int l = s1.length();
        int count = 0;


        for ( int k = 0; k < l; ++k ) {

            char c1 = s1.charAt(k);
            char c2 = s2.charAt(k);

            if ( c1 == c2 ) {
                continue;
            }

            count++;
        }


        return count == 1;

    }

    public static void main(String[] args) {

        WordLadderII wordLadderII = new WordLadderII();

        List<String> dict = List.of(
                "hot","dot","dog","lot","log","cog"
        );

        for ( List<String> s : wordLadderII.findLadders("hit", "cog",dict ) ) {
            for ( String w : s ) {
                System.out.print(w + ":");
            }
            System.out.println();
        }

    }


}
