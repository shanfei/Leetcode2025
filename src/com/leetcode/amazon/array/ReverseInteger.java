package com.leetcode.amazon.array;

/**
 *
 * Given a signed 32-bit integer x, return the reverse of x.
 * If the reversed value of x goes beyond the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * A reverse of x should not contain leading zeros.
 *
 * Examples
 *
 * Example 1:
 *
 * Input: x = 123
 * Expected Output: 321
 * Justification: Reversing the digits of 123 results in 321, which is within the 32-bit signed integer range.
 *
 * Example 2:
 *
 * Input: x = -456432
 * Expected Output: -234654
 * Justification: Reversing the digits of -456432 results in -234654, maintaining the negative sign and staying within the 32-bit signed integer range.
 *
 * Example 3:
 *
 * Input: x = 1200
 * Expected Output: 21
 * Justification: Reversing the digits of 1200 results in 0021, but leading zeros are dropped, resulting in 21.
 *
 *
 */
public class ReverseInteger {


    public int reverse(int x) {

        int k = 0;

        int sign = x < 0 ? -1 : 1;

        int t = Math.abs(x);

        while ( t > 0 ) {

            int digit = t % 10;
            int nr  = k * 10 + digit;

            int d = t / 10;

            if ((nr - digit) / 10 != k ) return 0;

            k = nr;
            t = d;
        }

        return sign * k;
    }


}
