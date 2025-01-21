package com.concurrent;

public class ProducerT implements Runnable {

    ProducerAndConsumer producerAndConsumer;

    public ProducerT(ProducerAndConsumer producerAndConsumer) {
        this.producerAndConsumer = producerAndConsumer;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 10; ++i) {
                System.out.println("Producer is Running");
                producerAndConsumer.produce();
            }
            producerAndConsumer.done();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }


    }
}

