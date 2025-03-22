package org.knit.solutions;

import org.knit.solutions.lab2sem2.Consumer;
import org.knit.solutions.lab2sem2.DistributionPoint;
import org.knit.solutions.lab2sem2.Producer;

public class Task7 {
    public static void execute() throws InterruptedException {
        DistributionPoint distributionPoint = new DistributionPoint();
        Producer producer = new Producer(distributionPoint);
        Consumer consumer = new Consumer(distributionPoint);

        producer.start();
        consumer.start();
    }

    public static void main(String[] args) throws InterruptedException {
        execute();
    }
}