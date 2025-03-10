package com.meta.prefixsum;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumOfSubmatrixSumToTarget {

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {

        int r = matrix.length, c = matrix[0].length;

        // compute 2D prefix sum
        int[][] ps = new int[r + 1][c + 1];

        for (int i = 1; i < r + 1; ++i) {
            for (int j = 1; j < c + 1; ++j) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int count = 0, currSum;
        Map<Integer, Integer> h = new HashMap();
        // reduce 2D problem to 1D one
        // by fixing two rows r1 and r2 and
        // computing 1D prefix sum for all matrices using [r1..r2] rows
        for (int r1 = 1; r1 < r + 1; ++r1) {
            for (int r2 = r1; r2 < r + 1; ++r2) {
                h.clear();
                h.put(0, 1);
                for (int col = 1; col < c + 1; ++col) {
                    // current 1D prefix sum
                    currSum = ps[r2][col] - ps[r1 - 1][col];

                    // add subarrays which sum up to (currSum - target)
                    count += h.getOrDefault(currSum - target, 0);

                    // save current prefix sum
                    h.put(currSum, h.getOrDefault(currSum, 0) + 1);
                }
            }
        }

        return count;
    }

    /**
     *
     * top + left - top-left + current = prefixSum
     *
     * @param matrix
     * @param indexMap
     * @return
     */
    static Map<Integer, Integer> calculatePrefixSum(int[][] matrix, Map<Pair<Integer, Integer>, Integer> indexMap) {


        Map<Integer, Integer> r = new HashMap<>();

        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[i].length; j++ ) {

                int mappedIndex = indexMap.get( new Pair<>(i, j) );

                int topPrefix = j - 1 < 0 ? 0 : r.getOrDefault(indexMap.get(new Pair<>(i,j - 1)), 0);
                int leftPrefix = i - 1 < 0 ? 0 :  r.getOrDefault(indexMap.get(new Pair<>(i - 1,j)), 0);
                int topLeftPrefix = i - 1 < 0 || j - 1 < 0 ? 0 :  r.getOrDefault(indexMap.get(new Pair<>(i - 1,j - 1)), 0);
                int topLeft = i - 1 < 0 || j - 1 < 0 ? 0 :  matrix[i - 1][j - 1];

                int c =  leftPrefix + topPrefix - topLeftPrefix  + topLeft;

                r.putIfAbsent(mappedIndex, c);
            }
        }

        return r;
    }

    static Pair<Map<Pair<Integer, Integer>, Integer>, List<Integer>> getMappedIndex(int[][] matrix) {

        Pair< Map<Pair<Integer, Integer>, Integer>, List<Integer>> map = new Pair<>(
          new HashMap<>(), new ArrayList<>() );

        List<Integer> l = map.getSecond();
        Map<Pair<Integer, Integer>, Integer> m = map.getFirst();

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                int mappedIndex = i * matrix[i].length + j;
                l.add(mappedIndex);
                Pair<Integer, Integer> k = new Pair<>(i, j);
                m.put(k, mappedIndex);
            }
        }

        return map;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,0},{1,1,1},{0,1,0}};
        int target = 0;

        System.out.println(numSubmatrixSumTarget(matrix, target));

    }

}
