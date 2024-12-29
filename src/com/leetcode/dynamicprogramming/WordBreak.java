package com.leetcode.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	/**
	 *
	 * dp[i][j] = dp[i - 1][j - 1] is
	 *
	 */
	public boolean wordBreak(String s, List<String> wordDict) {

		int[][] dp = new int[s.length()][s.length()];

		Set<String> ss = new HashSet<>();

		for (String w : wordDict) {
			ss.add(w);
		}

		return helper(s, 0, dp, ss);

	}

	boolean helper(String s, int start, int[][] dp, Set<String> ss) {

		boolean r = false;

		if (start == s.length()) {
			return true;
		}

		for (int i = 0; i + start < s.length(); ++i) {

			if (dp[start][start + i] == 1) {
				r = r && helper(s, start + i, dp, ss);
			} else {
				String w = s.substring(start, start + i + 1);
				if (ss.contains(w)) {
					dp[start][start + i] = 1;
					r = r || helper(s, start + i + 1, dp, ss);
				}
			}
		}

		return r;
	}
}
