package com.designguru.code.pattern.subset;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsByChangeCase {

    public List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();

        char[] chars = str.toCharArray();

        List<List<Character>> result = new ArrayList<>();
        List<Character> sublist = new ArrayList<>();

        findLetterCaseStringPermutations(chars, result, new ArrayList<>(), sublist, 0);

        for ( List<Character> r : result ) {
            StringBuilder sb = new StringBuilder();
            for ( Character c : r ) {
                sb.append(c);
            }
            permutations.add(sb.toString());
        }


        return permutations;
    }

    void findLetterCaseStringPermutations(char[] chars, List<List<Character>> result, List<Character> c, List<Character> sublist, int index) {

        if ( sublist.size() == chars.length ) {
            result.add(new ArrayList<>(sublist));
            return;
        }

        for ( int i = index; i < chars.length; i++ ) {

            char ch = chars[i];

            if ( Character.isLetter(ch) ) {

                char lc = Character.toLowerCase(ch);

                if (  !c.contains(lc) ) {

                    sublist.add(lc);
                    c.add(lc);

                    findLetterCaseStringPermutations(chars, result, c, sublist, i + 1);

                    c.remove(c.size() - 1);
                    sublist.remove(sublist.size() - 1);
                }

                char lw = Character.toUpperCase(ch);

                if ( !c.contains(lw) ) {

                    sublist.add(lw);
                    c.add(lc);

                    findLetterCaseStringPermutations(chars, result, c, sublist, i + 1);

                    c.remove(c.size() - 1);
                    sublist.remove(sublist.size() - 1);
                }

            } else {

                sublist.add(ch);

                findLetterCaseStringPermutations(chars, result, c, sublist, i + 1);

                sublist.remove(sublist.size() - 1);

            }
        }
    }
}
