package org.knit.solutions;

import org.knit.solutions.lab2sem2.Cook;
import org.knit.solutions.lab2sem2.Restaurant;
import org.knit.solutions.lab2sem2.Waiter;

public class Task5 {
    public static void execute() {
        Restaurant restaurant = new Restaurant();
        Cook cook = new Cook(restaurant);
        Waiter waiter = new Waiter(restaurant);
        cook.start();
        waiter.start();
    }
}
