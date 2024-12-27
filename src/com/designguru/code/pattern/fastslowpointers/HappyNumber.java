package com.designguru.code.pattern.fastslowpointers;

/**
 *
 * Any number will be called a happy number if,
 * after repeatedly replacing it with a number equal to the sum of the square of all of its digits,
 * leads us to the number 1. All other (not-happy) numbers will never reach 1. Instead,
 * they will be stuck in a cycle of numbers that does not include 1.
 *
 * Given a positive number n, return true if it is a happy number otherwise return false.
 *
 */
public class HappyNumber {

    public boolean find(int num) {

        int s = num;
        int f = num;

        do {

            if ( f == 1 || s == 1 ) return true;

            s = calculateTheSum(s);
            f = calculateTheSum(calculateTheSum(f));

        } while ( s != f );

        return s == 1;
    }

    int calculateTheSum(int num) {

        int a = num;

        int sum = 0;

        while ( a > 0 ) {

            int b = a / 10;
            int r = a % 10;

            sum += r * r;

            a = b;
        }

        return sum;
    }
}
