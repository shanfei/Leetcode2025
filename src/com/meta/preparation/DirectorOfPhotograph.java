package com.meta.preparation;

import java.util.*;

class Range {
    int start;
    int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return start == range.start && end == range.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}

public class DirectorOfPhotograph {



        public int getArtisticPhotographCount(int N, String C, int X, int Y) {



            return combination(0,0, C, X, Y, new HashSet(), new HashMap<>());
        }

        public int combination( int start, int currentIndex, String s, int x, int y, Set<Character> path, Map<Range, Integer> cache ) {

            if ( currentIndex >= s.length() ) {
                return 0;
            }

            Range r = new Range(start, currentIndex);

            if (cache.get(r) != null) {
                return cache.get(r);
            }

            char c = s.charAt(currentIndex);

            int retCount = 0;

            if ( c == 'P' ) {

                if ( path.isEmpty() ) {

                    path.add(c);

                    for ( int i = x; i <= y; ++i ) {

                        retCount += combination(start, currentIndex + i, s, x, y, path, cache);

                    }

                    path.remove(c);

                } else if ( path.contains('B') && path.contains('A') ) {
                    path.clear();
                    retCount++;
                    retCount += combination(currentIndex + 1, currentIndex + 1, s, x, y, path, cache);
                } else {
                    path.clear();
                    path.add(c);
                    retCount += combination(currentIndex, currentIndex + 1, s, x, y, path, cache);
                }

            } else if ( c == 'B' ) {

                if ( path.isEmpty() ) {

                    path.add(c);

                    for ( int i = x; i <= y; ++i ) {
                        retCount += combination(start, currentIndex + i, s, x, y, path, cache);
                    }

                    path.remove(c);

                } else if ( path.contains('P') && path.contains('A') ) {
                    path.clear();
                    retCount++;
                    retCount += combination(currentIndex + 1, currentIndex + 1, s, x, y, path, cache);
                } else {
                    path.clear();
                    path.add(c);
                    retCount += combination(currentIndex ,currentIndex + 1, s, x, y, path, cache);
                }
            } else if ( c == '.' ) {
                retCount += combination(start,currentIndex + 1, s, x, y, path, cache);
            } else if ( c == 'A' ) {

                if ( !path.isEmpty() && path.contains('B') && path.contains('P') ) {
                    path.clear();
                    retCount += combination(currentIndex + 1, currentIndex + 1, s, x, y, path, cache);
                } else if ( !path.isEmpty() && ( path.contains('B') || path.contains('P')) ) {

                    path.add(c);

                    for ( int i = x; i <= y; ++i ) {
                        retCount += combination(start,currentIndex + i, s, x, y, path, cache);
                    }

                    path.remove(c);

                }  else {
                    path.clear();
                    retCount += combination(currentIndex + 1,currentIndex + 1, s, x, y, path, cache);
                }

            }
            cache.put(r, retCount);

            return retCount;

        }


        public static void main(String[] args) {
            DirectorOfPhotograph d = new DirectorOfPhotograph();
            System.out.println(d.getArtisticPhotographCount(8, ".PBAAP.B",1,3));
        }



}
