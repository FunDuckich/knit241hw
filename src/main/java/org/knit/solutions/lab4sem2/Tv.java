package org.knit.solutions.lab4sem2;

public class Tv {
    private final String location;
    private int channel;
    private boolean isOn;

    public Tv(String location) {
        this.location = location;
        this.isOn = false;
    }

    public void on() {
        this.isOn = true;
        System.out.println(location + " телевизор включен.");
    }

    public void off() {
        this.isOn = false;
        System.out.println(location + " телевизор выключен.");
    }

    public void setChannel(int channel) {
        if (this.isOn) {
            this.channel = channel;
            System.out.println(location + " телевизор переключен на канал " + this.channel);
        } else {
            System.out.println(location + " телевизор выключен, невозможно переключить канал.");
        }
    }

    public int getChannel() {
        return channel;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getLocation() {
        return location;
    }
}
