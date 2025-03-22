package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2sem2.Car;
import org.knit.solutions.lab2sem2.GasStation;

@TaskDescription(taskNumber = 4, taskDescription = "Краткое описание задачи 1", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task4 implements Solution {
    public void execute() {
        GasStation gasStation = new GasStation();

        for (int i = 1; i <= 10; i++) {
            Car car = new Car(gasStation);
            car.start();
        }
    }
}
