package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2sem2.Consumer;
import org.knit.solutions.lab2sem2.DistributionPoint;
import org.knit.solutions.lab2sem2.Producer;

@TaskDescription(taskNumber = 7, taskDescription = "Производитель-Потребитель с ограничением", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task7 implements Solution {
    @Override
    public void execute() {
        DistributionPoint distributionPoint = new DistributionPoint();
        Producer producer = new Producer(distributionPoint);
        Consumer consumer = new Consumer(distributionPoint);

        producer.start();
        consumer.start();
    }
}