package com.meta.stack;

import java.util.Set;
import java.util.Stack;

public class MinAddToMakeParensisValid {

    Set<Character> set = Set.of('(', ')');

    public int minAddToMakeValid(String s) {

        int open = 0;

        int min = 0;

        for ( char c : s.toCharArray() ) {

            if ( !set.contains(c) ) {
                continue;
            }

            if ( c == '(' ) {
               open++;
            } else {
                if (open == 0) {
                    min++;
                }
                open--;
            }
        }

        return min + open;
    }
}
