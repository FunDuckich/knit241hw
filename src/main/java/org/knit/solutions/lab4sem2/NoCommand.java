package org.knit.solutions.lab4sem2;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Команда не назначена.");
    }

    @Override
    public void undo() {
        System.out.println("Нет команды для отмены.");
    }
}
