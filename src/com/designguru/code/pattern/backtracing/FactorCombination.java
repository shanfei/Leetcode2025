package com.designguru.code.pattern.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Numbers can be regarded as the product of their factors.
 *
 * For example, 8 = 2 x 2 x 2 = 2 x 4.
 *
 * Given an integer n, return all possible combinations of its factors. You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: n = 8
 * Output: [[2, 2, 2], [2, 4]]
 * Example 2:
 *
 * Input: n = 20
 * Output: [[2, 2, 5], [2, 10], [4, 5]]
 *
 */
public class FactorCombination {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getPrimeFactors(n, new ArrayList<>(), result, 2);
        return result;
    }

    void getPrimeFactors(int n, List<Integer> p, List<List<Integer>> r, int start) {

        double half = Math.sqrt(n);

        for ( int i = start; i <= half; ++i ) {
            if ( n % i == 0 ) {
                p.add(i);
                List<Integer> result = new ArrayList<>(p);
                result.add( n / i );
                r.add(new ArrayList<>(result));
                getPrimeFactors(n / i, p, r, i);
                p.remove(p.size() - 1);
            }
        }
    }

}
