package com.leetcode.dynamicprogramming;

/**
 *
 * Leetcode 70
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 */
public class ClimbingStairs {

	public int climbStairs(int n) {

		int[] cache = new int[n];

		return topDown(n, cache);

	}

	public int topDown(int n, int[] cache) {

		if (n == 1) return 1;
		if (n == 2) return 2;

		cache[0] = 1;
		cache[1] = 2;

		for (int i = 2; i < n; ++i) {
			cache[i] = cache[i - 1] + cache[i - 2];
		}

		return cache[n - 1];

	}

	public int bottomUp(int n, int[] cache) {

		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		if (cache[n - 1] != 0) {
			return cache[n - 1];
		}

		int k = bottomUp(n - 1, cache) + bottomUp(n - 2, cache);

		cache[n - 1] = k;

		return k;
	}

}
