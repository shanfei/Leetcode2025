package com.leetcode.amazon;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperations {

    public int minimumOperations(int[] nums) {


        Set<Integer> s = new HashSet<>();

        for ( int n : nums ) {
            s.add(n);
        }

        return Long.valueOf(s.stream().filter( i -> i > 0 ).count()).intValue();

    }

    public static void main(String[] args) {
        MinimumOperations m = new MinimumOperations();
        System.out.println(m.minimumOperations(new int[] {1,5,0,3,5}));
        System.out.println(m.minimumOperations(new int[] {0}));
    }
}
