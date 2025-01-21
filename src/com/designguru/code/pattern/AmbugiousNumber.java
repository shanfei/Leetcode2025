package com.designguru.code.pattern;

import java.util.Map;

public class AmbugiousNumber {

    static final Map<Integer, Integer> m = Map.of(
            1,1,
            6,9,
            9,6,
            8,8,
            0,0
            );

    public static int number(int v) {

        int p = v;
        int newNum = 0;

        while ( p > 0 ) {

            int r = p % 10;

            if ( !m.containsKey(r) ) {
                return 0;
            }

            int l = m.get(r);

            p /= 10;
            newNum = newNum * 10 + l;
        }

        return newNum == v ? 1 : 2;

    }

    public static void main(String[] args) {
        System.out.println(number(693));
        System.out.println(number(689));
        System.out.println(number(691));
    }

}