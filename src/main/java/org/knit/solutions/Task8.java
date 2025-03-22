package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2sem2.CarInTrafficLightTask;
import org.knit.solutions.lab2sem2.TrafficLight;
import org.knit.solutions.lab2sem2.TrafficLightController;

@TaskDescription(taskNumber = 8, taskDescription = "Перекресток: светофор и машины", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task8 implements Solution {
    @Override
    public void execute() {
        TrafficLight trafficLight = new TrafficLight();
        TrafficLightController trafficLightController = new TrafficLightController(trafficLight);
        CarInTrafficLightTask car1 = new CarInTrafficLightTask(trafficLight);
        CarInTrafficLightTask car2 = new CarInTrafficLightTask(trafficLight);
        CarInTrafficLightTask car3 = new CarInTrafficLightTask(trafficLight);

        trafficLightController.start();
        car1.start();
        car2.start();
        car3.start();
    }
}