package com.meta.preparation;


import common.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AboveAverage {

    public static Interval[] aboveAverageInterval(int[] input) {

        int total = Arrays.stream(input).sum();

        List<Interval> r = new ArrayList<>();

        for (int i = 0; i < input.length; ++i) {

            int subSum = 0 ;

            for (int j = i; j < input.length; ++j) {

                int countOfSub = j - i + 1;
                subSum += input[j];
                int remainSum = total - subSum;
                int remainCount = input.length - countOfSub + 1;

                if (average(subSum, countOfSub) >= average(remainSum, remainCount)) {
                    r.add(new Interval(i + 1, j + 1));
                }
            }
        }

        Interval[] ret = r.toArray(new Interval[]{new Interval()});

        Arrays.sort(ret, (a,b) -> {
            return a.start - b.start;
        });

        return ret;

    }

    public static int average(int sum, int count) {
        return sum / count;
    }

    public static void main(String[] args) {

        List<int[]> p = List.of(
              new int[] {6, 4, 10}
        );

        for (int[] pp : p) {
            Interval[] r = aboveAverageInterval(pp);
            System.out.println(r.length);
            for (Interval i : r) {
                System.out.println(String.format(" %d - %d", i.start, i.end));
            }
        }
    }
}
