package com.leetcode.dynamicprogramming;

public class MinCostClimbingStairs {

	/**
	 * totalCost[0], totalCost[1]
	 *
	 * totalCost(i) = min(totalCost(i - 1), totalCost(i - 2)) + cost[i]
	 *
	 */

	public int minCostClimbingStairs(int[] cost) {

		int[] totalMinCostCache = new int[cost.length];

		totalMinCostCache[0] = cost[0];
		totalMinCostCache[1] = cost[1];

		for (int i = 2; i < cost.length; ++i) {
			totalMinCostCache[i] = Math.min(totalMinCostCache[i - 1], totalMinCostCache[i - 2]) + cost[i];
		}
		return Math.min(totalMinCostCache[cost.length - 2], totalMinCostCache[cost.length - 1]);

	}
}
