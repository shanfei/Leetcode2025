package com.concurrent;

public interface ProducerAndConsumer {

    void done();

    void produce() throws InterruptedException;

    void consume() throws InterruptedException;

    boolean isDone();
}
