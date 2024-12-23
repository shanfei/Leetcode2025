package com.hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class FindMaxLengthParadiamCount {

    static String ss;

    public static void init(String s) {
        ss = s;
    }

    public static int answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
        String substr = ss.substring(l - 1, r);

        return findMaxLengthParadromeCount(substr);
    }

    protected static int findMaxLengthParadromeCount(String str) {

        Map<Character, Integer> statisticMap = distinctCharCount(str);

        int evenCount = 0;
        int oddCount = 0;
        int totalOddCount = 0;

        for ( char key : statisticMap.keySet() ) {

            int count = statisticMap.get(key);

            if ( count % 2 == 0 ) {
                evenCount += count;
                statisticMap.put(key, count / 2);
            } else {
                totalOddCount++;
                if ( count > 1 ) {
                    oddCount += count;
                    statisticMap.put(key, count / 2);
                } else {
                    statisticMap.put(key, 0);
                }
            }
        }


        int totalCount = evenCount / 2 + ( oddCount / 2 );

        return combinationOfParadrome(statisticMap, new StringBuilder(), new HashSet<String>(), totalCount) * (totalOddCount / 2 + 1);

    }

    protected static int combinationOfParadrome(
            Map<Character, Integer> statisticMap,
            StringBuilder sb,
            Set<String> p,
            int totalCountOfHalfParadromeString) {

        if (totalCountOfHalfParadromeString == 0) {
            return 1;
        }

        int totalCount = 0;

        for ( Map.Entry<Character, Integer> entry : statisticMap.entrySet() ) {
            char key = entry.getKey();
            int count = entry.getValue();

            if (count == 0) {
                continue;
            }

            sb.append(key);

            if (p.contains(sb.toString())) {
                continue;
            }

            if ( count > 0 ) {
                statisticMap.put(key, count - 1);
                totalCount += combinationOfParadrome(statisticMap, sb, p, totalCountOfHalfParadromeString - 1 );
                statisticMap.put(key, count);
                sb.deleteCharAt(sb.length() - 1);
            }

        }

        return totalCount;
    }

    protected static Map<Character, Integer> distinctCharCount(String str) {
        Map<Character, Integer> ret = new HashMap<>();

        for (char c : str.toCharArray()) {
            ret.put(c, ret.getOrDefault(c, 0) + 1);
        }

        return ret;
    }

    public static void main(String[] args)  {
        FindMaxLengthParadiamCount.init("ccccaaaaaaaaaaaabbbbaaaacccccccccbacaaaabbbbcbaccbacccccwhatcccccbacccccaaaabbbbabbabbbbcbacabbawhat");
        System.out.println(FindMaxLengthParadiamCount.answerQuery(91,92));
        System.out.println(FindMaxLengthParadiamCount.answerQuery(38,40));
        System.out.println(FindMaxLengthParadiamCount.answerQuery(79,80));
        System.out.println(FindMaxLengthParadiamCount.answerQuery(5,10));

    }

}

class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        FindMaxLengthParadiamCount.init(s);

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int l = Integer.parseInt(firstMultipleInput[0]);

                int r = Integer.parseInt(firstMultipleInput[1]);

                int result = FindMaxLengthParadiamCount.answerQuery(l, r);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


