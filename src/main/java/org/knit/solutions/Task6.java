package org.knit.solutions;


import org.knit.solutions.lab2sem2.CarInTrainTask;
import org.knit.solutions.lab2sem2.Railroad;
import org.knit.solutions.lab2sem2.Train;

public class Task6 {
    public static void execute() throws InterruptedException {
        Railroad railroad = new Railroad();
        Train train = new Train(railroad);
        CarInTrainTask car = new CarInTrainTask(railroad);

        train.start();
        car.start();
    }
}