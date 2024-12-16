package com.servicenow;

import java.util.*;

/**
 *
 * Leetcode: 2318
 *
 * 给你一个整数 n 。你需要掷一个 6 面的骰子 n 次。请你在满足以下要求的前提下，求出 不同 骰子序列的数目：
 *
 * 序列中任意 相邻 数字的 最大公约数 为 1 。
 * 序列中 相等 的值之间，至少有 2 个其他值的数字。正式地，如果第 i 次掷骰子的值 等于 第 j 次的值，那么 abs(i - j) > 2 。
 * 请你返回不同序列的 总数目 。由于答案可能很大，请你将答案对 109 + 7 取余 后返回。
 *
 * 如果两个序列中至少有一个元素不同，那么它们被视为不同的序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：184
 * 解释：一些可行的序列为 (1, 2, 3, 4) ，(6, 1, 2, 3) ，(1, 2, 3, 1) 等等。
 * 一些不可行的序列为 (1, 2, 1, 3) ，(1, 2, 3, 6) 。
 * (1, 2, 1, 3) 是不可行的，因为第一个和第三个骰子值相等且 abs(1 - 3) = 2 （下标从 1 开始表示）。
 * (1, 2, 3, 6) i是不可行的，因为 3 和 6 的最大公约数是 3 。
 * 总共有 184 个不同的可行序列，所以我们返回 184 。
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：22
 * 解释：一些可行的序列为 (1, 2) ，(2, 1) ，(3, 2) 。
 * 一些不可行的序列为 (3, 6) ，(2, 4) ，因为最大公约数不为 1 。
 * 总共有 22 个不同的可行序列，所以我们返回 22 。
 *
 */

public class DistinctSequences {

    static Map<Integer, Set<Integer>> primeNumbers = Map.of(
            1, Set.of(1,2,3,4,5,6),
            2, Set.of(1,2,3,5),
            3, Set.of(1,2,3,4,5),
            4, Set.of(1,3,4,5),
            5, Set.of(1,2,3,4,6),
            6, Set.of(1,5,6)
    );


    public static int distinctSequences(int n) {

        int[][][] c = new int[n][7][7];

        return distinctSequencesR(n, 7, 7, c);

    }

    static int distinctSequencesR(int n, int l1, int l2, int[][][] c) {

        if ( n == 0 ) {
            return 1;
        }

        if ( c[n - 1][l1 - 1][l2 - 1] != 0 ) {
            return c[n - 1][l1 - 1][l2 - 1];
        }

        int r = 0;

        for ( int i = 1; i <= 6; ++i ) {

            if ( !nextAttempt(i, l1, l2) ) {
                continue;
            }

            int k = distinctSequencesR(n - 1, i, l1, c);

            r = ( ( r + k ) % (  Double.valueOf(Math.pow(10, 9) + 7)).intValue() );

        }

        c[n - 1][l1 - 1][l2 - 1] = r;

        return c[n - 1][l1 - 1][l2 - 1];
    }

    static boolean nextAttempt(int s, int l1, int l2) {
        // 1. the next number should be prime
        if ( l1 != 7 && !primeNumbers.get(s).contains(l1)) {
            return false;
        }

        // 2 continues positions can not store same number
        return s != l1 && s != l2;
    }

    public static void main(String[] args) {
        System.out.println(distinctSequences(20));
    }
}
