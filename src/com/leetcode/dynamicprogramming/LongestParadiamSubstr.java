package com.leetcode.dynamicprogramming;

public class LongestParadiamSubstr {

	/**
	 *
	 *  dp[i][j] = ( s[i] == s[j] && dp[i + 1][j - 1] )
	 *
	 *
	 */
	public String longestPalindrome(String s) {

		int[][] dp = new int[s.length()][s.length()];
		char[] ca = s.toCharArray();

		int maxX = 0;
		int maxY = 0;

		for (int i = 0; i < ca.length; ++i) {
			dp[i][i] = 1;
		}

		for (int i = 0; i < ca.length - 1; ++i) {
			if (ca[i] == ca[i + 1]) {
				dp[i][i + 1] = 1;
				maxX = i;
				maxY = i + 1;
			}
		}


		int windowSize = 2;


		while ( windowSize < ca.length ) {

			for (int i = 0; i < ( ca.length - windowSize ) ; ++i) {

				int j = i + windowSize;

				if ( ca[i] == ca[j] && ( ( dp[i + 1][j - 1] == 1 ) ) ) {

					dp[i][j] = 1;

					maxX = i;
					maxY = j;
				}
			}

			windowSize++;
		}


		return s.substring(maxX, maxY + 1);

	}
}
