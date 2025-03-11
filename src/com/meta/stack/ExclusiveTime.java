package com.meta.stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTime {

    public int[] exclusiveTime(int n, List<String> logs) {

        Stack<Log> stack = new Stack<>();

        int[] res = new int[n];

        Log log = parseLog(logs.get(0));

        stack.push(log);

        int prevValue = log.at;

        for ( int i = 1; i < logs.size(); ++i ) {

            log = parseLog(logs.get(i));

            if (!log.isEnd) {
                // calculate prev duration
                if ( !stack.isEmpty() ) {
                    Log prev = stack.peek();
                    res[prev.id] += log.at - prevValue;
                }

                prevValue = log.at;

                stack.push(log);

            } else {
                res[log.id] += log.at - prevValue + 1;
                prevValue = log.at + 1;
                stack.pop();
            }


        }

        return res;

    }

    Log parseLog(String log) {

        String[] ls = log.split(":");

        return new Log(ls[0], ls[1], ls[2]);

    }

    public static void main(String[] args) {
        ExclusiveTime et = new ExclusiveTime();
        List<String> l = List.of(
            "0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8"
        );
        int[] a = et.exclusiveTime(2, l );

        for (int t : a) {
            System.out.print(t + " : ");
        }

        System.out.println();
    }

}

class Log {

    public int id;
    public boolean isEnd = false;
    public int at;

    public Log(String id, String isEnd, String at) {
        this.id = Integer.parseInt(id);
        this.isEnd = isEnd.equals("end");
        this.at = Integer.parseInt(at);
    }
}
