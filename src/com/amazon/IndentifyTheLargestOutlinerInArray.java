package com.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IndentifyTheLargestOutlinerInArray {

    public static void main(String[] args) {
        IndentifyTheLargestOutlinerInArray s = new IndentifyTheLargestOutlinerInArray();

        System.out.println(s.getLargestOutlier(new int[]{2, 3, 5, 10}));
        System.out.println(s.getLargestOutlier(new int[]{-2, -1, -3, -6, 4}));
        System.out.println(s.getLargestOutlier(new int[]{1, 1, 1, 1, 1, 5, 5}));
    }

    public int getLargestOutlier(int[] nums) {

        int total = Arrays.stream(nums).sum();

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        int largest_outlier = Integer.MIN_VALUE;

        for (int num : frequencyMap.keySet()) {

            int potential_outlier = total - 2 * num;

            if (frequencyMap.containsKey(potential_outlier) && (potential_outlier != num || frequencyMap.get(num) > 1)) {
                largest_outlier = Math.max(largest_outlier, potential_outlier);
            }
        }

        return largest_outlier;

    }
}
