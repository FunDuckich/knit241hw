package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2sem2.Cook;
import org.knit.solutions.lab2sem2.Restaurant;
import org.knit.solutions.lab2sem2.Waiter;

@TaskDescription(taskNumber = 5, taskDescription = "Ресторан: Повар и Официант", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task5 implements Solution {
    @Override
    public void execute() {
        Restaurant restaurant = new Restaurant();
        Cook cook = new Cook(restaurant);
        Waiter waiter = new Waiter(restaurant);
        cook.start();
        waiter.start();
    }
}
