package com.designguru.code.pattern.counting;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 *
 * Given an array of positive integers named nums,
 * return the total frequencies of the elements in nums that have a maximum frequency.
 *
 * The frequency of an element is defined as the number of times that element is repeated in the array.
 *
 * Examples
 * Example 1:
 *
 * Input: nums = [3, 2, 2, 3, 1, 4]
 * Output: 4
 * Explanation: Both 2 and 3 appear twice, which is the highest frequency. So, the total frequency is 2 + 2 = 4.
 * Example 2:
 *
 * Input: nums = [5, 5, 5, 2, 2, 3]
 * Output: 3
 * Explanation: The number 5 appears three times, which is the highest frequency. So, the total frequency is 3.
 * Example 3:
 *
 * Input: nums = [7, 8, 8, 7, 9, 9]
 * Output: 6
 * Explanation: All elements appear twice. So, total maximum frequency is 2 + 2 + 2 = 6.
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 */
public class CountElementsWithMaxFrequency {

    public static int countMaxFrequency(int[] nums) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for ( int n : nums ) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        TreeMap<Integer, Set<Integer>> map = new TreeMap<>( (a, b) -> { return b - a; } );

        for ( Map.Entry<Integer, Integer> entry : frequencyMap.entrySet() ) {
            Integer count = entry.getValue();
            Integer number = entry.getKey();
            Set<Integer> s = map.getOrDefault(count, new HashSet<>());
            s.add(number);
            map.put(count, s);
        }

        return map.firstEntry().getKey() * map.firstEntry().getValue().size();
    }

    public static void main(String[] args) {

        int[][] input = {
                {3, 2, 2, 3, 1, 4},
                {5, 5, 5, 2, 2, 3},
                {7, 8, 8, 7, 9, 9}
        };

        for (int[] i : input) {
            System.out.println(countMaxFrequency(i));
        }
    }

}
