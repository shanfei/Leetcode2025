package com.leetcode.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * 1. 构建map
 * 2. 根据输入 确定 组合的所有元素
 * 3. 组合算法
 *
 */
public class LettersCombinationOfPhoneNumber {
	
	static Map<Character, Set<Character>> m = Map.of(
			'1', Set.of(),
			'2', Set.of('a', 'b', 'c'),
            '3', Set.of('d', 'e', 'f'),
            '4', Set.of('g', 'h', 'i'),
            '5', Set.of('j', 'k', 'l'),
            '6', Set.of('m', 'n', 'o'),
            '7', Set.of('p', 'q', 'r', 's'),
            '8', Set.of('t', 'u', 'v'),
            '9', Set.of('w', 'x', 'y', 'z')
	);

    public static List<String> letterCombinations(String digits) {

        char[] c = digits.toCharArray();

        List<String> result = new ArrayList<>();

        combination(c, 0, new StringBuilder(), result );

        return result;
    }

    static void combination( char[] c, int index, StringBuilder sb, List<String> result ) {

        if ( index == c.length ) {
            if (!sb.isEmpty()) {
                result.add( sb.toString() );
            }
            return;
        }

        char key = c[index];

        Set<Character> set = m.get(key);

        for ( char e : set ) {
            sb.append(e);
            combination( c, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    
    public static void main(String[] args) {
        List<String> result = letterCombinations("23");

        for (String s : result) {
            System.out.print(s + " : ");
        }

        System.out.println();

        result = letterCombinations("2");

        for (String s : result) {
            System.out.print(s + " : ");
        }

        System.out.println();


    }
}
