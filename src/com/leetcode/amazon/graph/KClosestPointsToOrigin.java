package com.leetcode.amazon.graph;

import java.util.ArrayList;
import java.util.List;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        int[] distancesUnsorted = new int[points.length];
        int maxDistance = 0;
        List<Integer> indexes = new ArrayList<>();

        for ( int i = 0; i < distancesUnsorted.length; ++i ) {
            distancesUnsorted[i] = calculateDistanceToOrigin(points[i]);
            maxDistance = Math.max(maxDistance,  distancesUnsorted[i]);
            indexes.add(i);
        }

        double s = 0, e = maxDistance;

        List<Integer> cloest = new ArrayList<>();

        while ( k > 0 ) {

            double m = (double)( s + e ) / 2;

            List<List<Integer>> splitted = split(distancesUnsorted, m, indexes);

            if ( splitted.get(0).size() > k ) {
                indexes = splitted.get(0);
                e = m;
            } else {
                k -= splitted.get(0).size();
                cloest.addAll(splitted.get(0));
                indexes = splitted.get(1);
                s = m;
            }
        }

        int[][] ret = new int[cloest.size()][2];

        for (int i = 0; i < cloest.size(); ++i ) {
            ret[i] = points[cloest.get(i)];
        }

        return ret;
    }

    public int calculateDistanceToOrigin(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public List<List<Integer>> split(int[] distances, double midValue, List<Integer> indexes) {

        List<List<Integer>> splited = List.of( new ArrayList<>(), new ArrayList<>() );

        for (int i : indexes ) {

            double d = distances[i];

            if ( d <= midValue ) {
                splited.get(0).add(i);
            } else {
                splited.get(1).add(i);
            }
        }

        return splited;

    }
}
