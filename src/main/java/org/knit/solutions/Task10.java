package org.knit.solutions;

import java.util.concurrent.*;

import org.knit.TaskDescription;
import org.knit.solutions.lab3sem2.Runner;

@TaskDescription(taskNumber = 10, taskDescription = "Гонка бегунов с использованием CyclicBarrier", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task10 implements Solution {
    @Override
    public void execute() {
        int numberOfRunners = 5;

        CyclicBarrier startBarrier = new CyclicBarrier(numberOfRunners, () ->
                System.out.println("Гонка началась!")
        );

        ExecutorService executor = Executors.newFixedThreadPool(numberOfRunners);

        for (int i = 1; i <= numberOfRunners; i++) {
            executor.submit(new Runner(i, startBarrier));
        }

        executor.shutdown();

        System.out.println("Все бегуны финишировали!");
    }
}
