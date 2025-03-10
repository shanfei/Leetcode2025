package com.meta.string;

import java.util.*;

/**
 *
 * Perform the following shift operations on a string:
 *
 * Right shift:
 *
 * Replace every letter with the successive letter of the English alphabet, where 'z' is replaced by 'a'.
 * For example, "abc" can be right-shifted to "bcd" or "xyz" can be right-shifted to "yza".
 *
 * Left shift:
 *
 * Replace every letter with the preceding letter of the English alphabet, where 'a' is replaced by 'z'.
 * For example, "bcd" can be left-shifted to "abc" or "yza" can be left-shifted to "xyz".
 * We can keep shifting the string in both directions to form an endless shifting sequence.
 *
 * For example, shift "abc" to form the sequence: ...
 * <-> "abc" <-> "bcd" <-> ... <-> "xyz" <-> "yza" <-> .... <-> "zab" <-> "abc" <-> ...
 *
 * You are given an array of strings strings, group together all strings[i] that belong to the same shifting sequence.
 * You may return the answer in any order.
 *
 * 1. same length
 * 2. same distance between characters
 *
 */
public class GroupShiftedString {

    public List<List<String>> groupStrings(String[] strings) {

        List<List<String>> ret = new ArrayList<>();

        Map<String, List<String>> cache = new HashMap<>();

        for ( String s : strings ) {

            String converted = hash(s);
            List<String> l = cache.getOrDefault(converted, new ArrayList<>());
            l.add(s);
            cache.put(converted, l);

        }

        ret.addAll(cache.values());

        return ret;

    }

    char convert(char c, int shift) {
        return  (char) ( ( c - shift + 26 )  % 26 + 'a' );
    }

    String hash(String s) {

        char[] cs = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        int shift = cs[0] - 'a';

        for ( int i = 0; i < cs.length; ++i ) {
            sb.append(convert(cs[i], shift));
        }

        return sb.toString();

    }

    public static void main(String[] args) {

    }
}
