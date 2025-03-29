package org.knit.solutions.lab3sem2;

import java.util.concurrent.*;
import java.util.Random;

public class Runner implements Runnable {
    private final int runnerId;
    private final CyclicBarrier startBarrier;
    private final Random random = new Random();

    public Runner(int runnerId, CyclicBarrier startBarrier) {
        this.runnerId = runnerId;
        this.startBarrier = startBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Бегун " + runnerId + " начал готовится!");
            Thread.sleep(random.nextInt(500));

            System.out.println("Бегун " + runnerId + " уже ожидает на старте!");
            startBarrier.await();

            int runTime = ThreadLocalRandom.current().nextInt(500, 3000);
            System.out.println("Бегун " + runnerId + " начал бежать и финиширует через " + runTime + "мс.");
            Thread.sleep(runTime);

            System.out.println("Бегун " + runnerId + " финишировал!");

        } catch (InterruptedException e) {
            System.out.println("Бегун " + runnerId + " был прерван во время гонки.");
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            System.out.println("Барьер сломан для бегуна " + runnerId + ".");
        }
    }
}
