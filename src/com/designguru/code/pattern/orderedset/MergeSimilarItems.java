package com.designguru.code.pattern.orderedset;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MergeSimilarItems {

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> result = new ArrayList<>();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }

        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }

        for (int key : map.keySet()) {
            result.add(List.of(key, map.get(key)));
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
