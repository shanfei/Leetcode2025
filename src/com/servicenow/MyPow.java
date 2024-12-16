package com.servicenow;

/**
 *
 *   ( ( ( 2 * 2 ) * ( 2 * 2 ) ) * ( ( 2 * 2 ) * ( 2 * 2 ) ) ) * ( 2 * 2 )
 *
 *   Leetcode: 50
 *
 *   log(N)
 *
 * implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 */

public class MyPow {

    public double myPow(double x, int n) {

        if ( n == 0 ) return 1;

        double r =  myPowR(x, (long)n);

        r = n < 0 ? 1 / r : r;

        return r;

    }

    double myPowR(double x, long n) {

        n = Math.abs(n);

        if ( n == 1 ) return x;

        double p = x;
        boolean isOdd = n % 2 > 0 ;

        if (isOdd) {
            p *= myPowR( p,  n - 1);
        } else {
            if ( n > 1 ) {
                p = myPowR( p, n / 2);
                p *= p;
            }
        }

        return p;
    }

    public static void main(String[] args) {
        MyPow instance = new MyPow();
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(instance.myPow(x, n));
    }

}
