package org.knit.solutions.lab4sem2;

public class Light {
    private final String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " свет включен.");
    }

    public void off() {
        System.out.println(location + " свет выключен.");
    }
}
