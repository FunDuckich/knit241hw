package org.knit.solutions.lab4sem2;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private final String name;
    private double price;
    private List<StockObserver> observers;

    public Stock(String name, double initialPrice) {
        this.name = name;
        this.price = initialPrice;
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (this.price != newPrice) {
            this.price = newPrice;
            System.out.println("--- Цена акции '" + name + "' изменилась на: " + this.price + " ---");
            notifyObservers();
        }
    }

    public void registerObserver(StockObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(this.name, this.price);
        }
    }
}
