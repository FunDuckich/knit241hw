package org.knit.solutions.lab2sem2;

public class Train extends Thread {
    private final Railroad railroad;

    public Train(Railroad railroad) {
        this.railroad = railroad;
    }

    @Override
    public void run() {
        while (true) {
            try {
                railroad.trainApproaches();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}