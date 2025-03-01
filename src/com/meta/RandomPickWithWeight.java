package com.meta;

import java.util.Arrays;
import java.util.Random;

/**
 *
 *
 *
 */
public class RandomPickWithWeight {

    int[] p;
    int sum = 0;

    public RandomPickWithWeight(int[] w) {

        p = new int[w.length];

        int prefixSum = 0;
        for ( int i = 0; i < p.length; ++i ) {
            int n = w[i];
            sum += n;
            prefixSum += n;
            p[i] = prefixSum;
        }

    }

    public int pickIndex() {

        double r = this.sum * Math.random();

        return binarySearch(this.p, r);


    }

    public int binarySearch(int[] array, double target) {

        int s = 0, e = array.length;

        while ( s < e ) {

            int m = ( s + e ) / 2;

            double v = array[m];

            if ( target < v ) {
                s = m + 1;
            } else {
                e = m;
            }
        }

        return s;

    }

    public static void main(String[] args) {
        int[] p = new int[] {1,3};
        RandomPickWithWeight w = new RandomPickWithWeight(p);

//        System.out.println(w.binarySearch(new double[][]{{0,0.25},{1,0.75}}, 0.25));
//        System.out.println(w.binarySearch(new double[][]{{0,0.25},{1,0.75}}, 0.75));
        //System.out.println(w.binarySearch(new double[][]{{0,0.15},{1,0.25}, {2,0.6}}, 0.6));


    }
}
