package com.concurrent;

public class ConsumerT implements Runnable {

    ProducerAndConsumer producerAndConsumer;

    public ConsumerT(ProducerAndConsumer producerAndConsumer) {
        this.producerAndConsumer = producerAndConsumer;
    }

    @Override
    public void run() {

        try {
            while (!producerAndConsumer.isDone()) {
                System.out.println("Consumer is Running");
                producerAndConsumer.consume();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }


    }
}

