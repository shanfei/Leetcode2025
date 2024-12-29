package com.leetcode.dynamicprogramming;

import java.util.*;

public class DeleteAndEarn {

	/**
	 *  maxCredits = [1, 2, 3, 3 (Math.max(3 (skip 2), 2)), 7 (3 + 4), 7 (Math.max(7, 5)), 7, 7, 13 (6 + 7) ]
	 *  maxCredit[i] is current maxGain on slot i,
	 *  there are 2 situations:
	 *       1. take i, so we can not take i - 1, the maxCredit we can take is i - 2,
	 *       2. don't take i, so maxCredit we can take is i - 1,
	 *. so maxCredit[i] = Math.max( maxCredit[i - 1], MaxCredit[i - 2] + gain )
	 *.
	 */
	public int deleteAndEarn(int[] nums) {

		TreeMap<Integer, Integer> countMap = new TreeMap<>();
		Map<Integer, Integer> maxProfits = new HashMap<>();

		int maxProfit = 0;

		for (int n : nums) {
			countMap.put(n, countMap.getOrDefault(n, 0) + 1);
		}

		for (Integer k : countMap.keySet()) {
			maxProfits.put(k, k * countMap.get(k));
		}

		List<Integer> cache = new LinkedList<>();
		cache.add(0);
		cache.add(maxProfits.getOrDefault(1, 0));

		for (int i = 2; i <= countMap.lastKey(); ++i) {
			int k = Math.max(cache.get(i - 1), cache.get(i - 2)  + maxProfits.getOrDefault(i, 0) );
			cache.add(k);
		}

		return cache.get(cache.size() - 1);

	}
}
