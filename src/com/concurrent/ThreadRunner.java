package com.concurrent;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadRunner {

    public static void main(String[] args) {

        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumerWithCondition();

        //ProducerAndConsumer producerAndConsumer = new ProducerAndConsumerWithSemorphe();

        List<Runnable> threads = List.of(
                new ProducerT(producerAndConsumer),
                new ProducerT(producerAndConsumer),
                new ProducerT(producerAndConsumer),
                new ConsumerT(producerAndConsumer),
                new ConsumerT(producerAndConsumer),
                new ConsumerT(producerAndConsumer),
                new ConsumerT(producerAndConsumer),
                new ConsumerT(producerAndConsumer)
                );



        ExecutorService threadPool = Executors.newFixedThreadPool(100);

        for (Runnable r : threads) {
            threadPool.execute(new Thread(r));
        }

        threadPool.shutdown();

    }
}
