package com.servicenow;

import java.util.*;

/**
 *
 * leetcode 49:
 *
 * encode "aab" => "a2b1"
 * encode "aabbccc" => "a2b2c3"
 *
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> m = new HashMap<>();

        for ( String s : strs ) {
            String key = encodeString(s);
            List<String> v = m.getOrDefault(key, new ArrayList<>());
            v.add(s);
            m.put(key, v);
        }

        return new ArrayList<>(m.values());

    }

    String encodeString(String str) {

        StringBuilder sb = new StringBuilder();
        TreeMap<Character, Integer> m = new TreeMap<>();

        for (char c : str.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        for ( Map.Entry<Character, Integer> e : m.entrySet() ) {
            sb.append(e.getKey()).append(e.getValue());
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        GroupAnagrams instance = new GroupAnagrams();

        String[] strs = {"a"};

        List<List<String>> r = instance.groupAnagrams(strs);

        for (List<String> s : r) {
            for (String ss : s) {
                System.out.print(ss + " : ");
            }
            System.out.println();
        }
    }
}
