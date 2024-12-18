package com.leetcode.dynamicprogramming;

public class HouseRobber {

	/**
	 *
	 *. maxMoney(i) = max( maxMoney(i - 2), maxMoney(i - 3) ....) + money(i)
	 *
	 */

	public int rob(int[] nums) {

		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[1], nums[0]);

		int[] cache = new int[nums.length];

		cache[0] = nums[0];
		cache[1] = Math.max(nums[0],nums[1]);
		cache[2] = nums[0] + nums[2];

		for (int i = 3; i < nums.length; ++i) {
			cache[i] = Math.max(cache[i - 2], cache[i - 3]) + nums[i];
		}

		return Math.max(cache[nums.length - 2], cache[nums.length - 1]);

	}

}
