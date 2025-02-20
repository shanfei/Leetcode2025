package com.meta;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        Set<List<Long>> l = new HashSet<>();
        long[] numsL = new long[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            numsL[i] = (long) nums[i];
        }

        for (int i = 0; i < nums.length - 3; ++i) {
            Set<List<Long>> k = null;
            for (int j = i + 1; j < nums.length - 2; ++j ) {
                int t = target - nums[i] - nums[j];
                k = twoSum(numsL, j + 1, nums.length - 1, t);

                if (!k.isEmpty()) {
                    for (List<Long> ll : k) {
                        ll.add(0,numsL[j]);
                        ll.add(0,numsL[i]);
                    }
                    l.addAll(k);
                }
            }
        }

        List<List<Integer>> rl = new ArrayList<>();

        for (List<Long> ln : l) {
            rl.add(ln.stream().map( n -> Long.valueOf(n).intValue()).toList());
        }

        return rl;

    }

    public Set<List<Long>> twoSum(long[] nums, int start, int end, long target) {

        Set<List<Long>> ret = new HashSet<>();

        while ( start < end ) {
            long k = target - nums[start];
            if ( k == nums[end]) {
                List<Long> rr = new ArrayList<>();
                rr.add(nums[start]);
                rr.add(nums[end]);
                ret.add(rr);
                start++;
                end--;
            } else if ( k < nums[end]) {
                end--;
            } else {
                start++;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        FourSum f = new FourSum();
        List<List<Integer>> r =  f.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        System.out.println(r.size());

        for (List<Integer> l : r) {
            for (int i : l) {
                System.out.print(i + " | ");
            }
            System.out.println();
        }

    }
}
