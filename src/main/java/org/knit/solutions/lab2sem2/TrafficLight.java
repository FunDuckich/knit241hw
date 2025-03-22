package org.knit.solutions.lab2sem2;

public class TrafficLight {
    private TrafficLightColor currentColor = TrafficLightColor.RED; // Начальный цвет - красный

    public synchronized void changeColor() throws InterruptedException {
        if (currentColor == TrafficLightColor.RED) {
            currentColor = TrafficLightColor.GREEN;
            System.out.println("ЗЕЛЕНЫЙ свет!");
            notifyAll();
        } else {
            currentColor = TrafficLightColor.RED;
            System.out.println("КРАСНЫЙ свет!");
        }
    }

    public synchronized void carApproaches() throws InterruptedException {
        while (currentColor == TrafficLightColor.RED) {
            wait();
        }
        System.out.println("Машина проехала");
        Thread.sleep(500);
    }

    public TrafficLightColor getCurrentColor() {
        return currentColor;
    }
}