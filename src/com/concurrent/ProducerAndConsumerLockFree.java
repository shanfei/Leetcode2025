package com.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerAndConsumerLockFree extends AbstractProducerAndConsumer {

    AtomicInteger currentCount = new AtomicInteger(0);

    @Override
    public void produce() throws InterruptedException {

        // Generate a random integer between 0 (inclusive) and 100 (exclusive)
        int randomNumber = random.nextInt(100);

        if ( this.currentCount.get() < this.capacity ) {


            cache.add(randomNumber);
            System.out.println(this.cache.size());
        }

        System.out.println(totalProducedCount.incrementAndGet());


    }

    @Override
    public void consume() throws InterruptedException {

        while (this.cache.isEmpty()) {


        }

        System.out.println("Consuming: " + cache.removeFirst());


    }
}
