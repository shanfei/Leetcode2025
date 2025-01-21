package com.concurrent;

import java.util.concurrent.Semaphore;

public class ProducerAndConsumerWithSemorphe extends AbstractProducerAndConsumer {

    Semaphore producerPermits = new Semaphore(2);
    Semaphore consumerPermits = new Semaphore(5);


    @Override
    public void produce() throws InterruptedException {

        producerPermits.acquire();


        try {


            synchronized (this) {
                while (isFull()) {
                    Thread.yield();
                }
            }

            // Generate a random integer between 0 (inclusive) and 100 (exclusive)
            int randomNumber = random.nextInt(100);
            cache.add(randomNumber);
            System.out.println(totalProducedCount.incrementAndGet());

        } finally {

            producerPermits.release();
        }
    }

    @Override
    public void consume() throws InterruptedException {

        consumerPermits.acquire();

        try {


            synchronized (this) {
                while (this.cache.isEmpty()) {
                    Thread.yield();
                }
            }

            System.out.println("Consuming: " + cache.removeFirst());

        } finally {

            consumerPermits.release();
        }


    }


}


