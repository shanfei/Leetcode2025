package com.leetcode.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class WebCrawlerMultiThreaded {

    Set<String> sameHostUrls = ConcurrentHashMap.newKeySet();

    //final static ExecutorService threadPool = Executors.newSingleThreadExecutor();

    volatile String hostUrl = null;

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

            if (sameHostUrls.contains(startUrl)) {
                return new ArrayList<>();
            }

            String hostUrl = extractHostname(startUrl);

            if (this.hostUrl == null) {
                this.hostUrl = hostUrl;
            } else if (!this.hostUrl.equalsIgnoreCase(hostUrl)) {
                return new ArrayList<>();
            }

            sameHostUrls.add(startUrl);

            List<String> urls = htmlParser.getUrls(startUrl);
            List<CompletableFuture<List<String>>> futures = new ArrayList<>();

            for (String url : urls) {

                if (sameHostUrls.contains(url)) {
                    continue;
                }

                CompletableFuture<List<String>> future = CompletableFuture.supplyAsync( () -> {
                    return crawl(url, htmlParser);
                });

                futures.add(future);

            }

            CompletableFuture<List<List<String>>> cfs = all(futures);

            try {
                List<List<String>> r = cfs.get();

                for (List<String> rs : r) {
                    sameHostUrls.addAll(rs);
                }
            } catch (Exception e) {
                e.fillInStackTrace();
            }


            return new ArrayList<>(sameHostUrls);

    }

    public static <T> CompletableFuture<List<T>> all(List<CompletableFuture<T>> futures) {

        CompletableFuture[] cfs = futures.toArray(new CompletableFuture[futures.size()]);

        return CompletableFuture.allOf(cfs)
                .thenApply(ignored -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
                );
    }

    String extractHostname(String url) {
        int indexOfHost1 = url.indexOf("://");
        int endIndexOfHost = url.indexOf("/", indexOfHost1 + 3);
        int withPortIndex = url.indexOf(":", indexOfHost1 + 3);
        int endIndex = withPortIndex == -1 ? endIndexOfHost : withPortIndex;
        endIndex = endIndex == -1 ? url.length() : endIndex;

        return url.substring(indexOfHost1 + 3, endIndex);

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String startUrl = "http://news.yahoo.com/news/topics/";

        WebCrawlerMultiThreaded webCrawlerMultiThreaded = new WebCrawlerMultiThreaded();

        HtmlParser htmlParser = new HtmlParser();

        List<String> results = webCrawlerMultiThreaded.crawl(startUrl, htmlParser);

        System.out.println(results.size());

        for (String r : results) {
            System.out.println(r);
        }
    }
}
