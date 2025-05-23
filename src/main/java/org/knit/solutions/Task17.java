package org.knit.solutions;

import org.knit.TaskDescription;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@TaskDescription(taskNumber = 17, taskDescription = "Реализация и проверка парадокса Монти Холла", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task17 implements Solution {

    private static final int NUM_DOORS = 3;
    private static final Random randomGenerator = new Random();

    private boolean runSingleGame(boolean strategySwitch) {
        int prizeDoor = randomGenerator.nextInt(NUM_DOORS);
        int playerInitialChoice = randomGenerator.nextInt(NUM_DOORS);

        List<Integer> doorsHostCanOpen = new ArrayList<>();
        for (int i = 0; i < NUM_DOORS; i++) {
            if (i != playerInitialChoice && i != prizeDoor) {
                doorsHostCanOpen.add(i);
            }
        }

        int hostOpenedDoor = doorsHostCanOpen.get(randomGenerator.nextInt(doorsHostCanOpen.size()));

        int finalPlayerChoice;
        if (strategySwitch) {
            finalPlayerChoice = 3 - playerInitialChoice - hostOpenedDoor;
        } else {
            finalPlayerChoice = playerInitialChoice;
        }
        return finalPlayerChoice == prizeDoor;
    }

    @Override
    public void execute() {
        int numSimulations = 10_000_000;

        int winsWithSwitching = 0;
        int winsWithoutSwitching = 0;

        System.out.println("Проведение " + numSimulations + " симуляций парадокса Монти Холла...");

        for (int i = 0; i < numSimulations; i++) {
            if (runSingleGame(true)) {
                winsWithSwitching++;
            }
            if (runSingleGame(false)) {
                winsWithoutSwitching++;
            }
        }

        double probabilityWithSwitching = (double) winsWithSwitching / numSimulations * 100.0;
        double probabilityWithoutSwitching = (double) winsWithoutSwitching / numSimulations * 100.0;

        System.out.println("\n--- Результаты симуляции ---");
        System.out.println("Количество игр: " + numSimulations);

        System.out.print("Стратегия 'Менять выбор':\n");
        System.out.printf("  Побед: %d\n", winsWithSwitching);
        System.out.printf("  Вероятность выигрыша: %.2f%%\n", probabilityWithSwitching);

        System.out.print("\nСтратегия 'Оставаться при своем выборе':\n");
        System.out.printf("  Побед: %d\n", winsWithoutSwitching);
        System.out.printf("  Вероятность выигрыша: %.2f%%\n", probabilityWithoutSwitching);

        System.out.println("\nВывод: смена выбора двери действительно увеличивает шансы на выигрыш примерно до 2/3,");
        System.out.println("в то время как сохранение выбора оставляет шансы на уровне 1/3.");
    }
}