package org.knit.solutions;


import org.knit.TaskDescription;
import org.knit.solutions.lab2sem2.CarInTrainTask;
import org.knit.solutions.lab2sem2.Railroad;
import org.knit.solutions.lab2sem2.Train;

@TaskDescription(taskNumber = 6, taskDescription = "Железнодорожный переезд", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task6 implements Solution {
    public void execute() {
        Railroad railroad = new Railroad();
        Train train = new Train(railroad);
        CarInTrainTask car = new CarInTrainTask(railroad);

        train.start();
        car.start();
    }
}