package com.leetcode.concurrent;

import java.util.List;
import java.util.Map;

public class HtmlParser {

    Map<String,Integer> urlsMap = Map.of(
            "http://news.yahoo.com",0,
            "http://news.yahoo.com/news",1,
            "http://news.yahoo.com/news/topics/",2,
            "http://news.google.com",3,
            "http://news.yahoo.com/us",4
    );

    Map<Integer, List<Integer>> edges = Map.of(
            2,List.of(0,1),
            3,List.of(2,1),
            0,List.of(4)
    );

    String[] urls = new String[] {
            "http://news.yahoo.com",
            "http://news.yahoo.com/news",
            "http://news.yahoo.com/news/topics/",
            "http://news.google.com",
            "http://news.yahoo.com/us"
    };

    public List<String> getUrls(String url) {
        int index = urlsMap.get(url);
        return edges.get(index).stream().map( i -> urls[i] ).toList();
    }
}
