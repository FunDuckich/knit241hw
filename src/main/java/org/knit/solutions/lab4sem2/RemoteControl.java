package org.knit.solutions.lab4sem2;

import java.util.Stack;

public class RemoteControl {
    private Command currentCommand;
    private final Stack<Command> commandHistory; // Для отмены нескольких команд (хотя в задаче одна)

    public RemoteControl() {
        this.commandHistory = new Stack<>();
        // Инициализация NoCommand, чтобы избежать NullPointerException
        this.currentCommand = new NoCommand();
    }

    public void setCommand(Command command) {
        this.currentCommand = command;
    }

    public void pressButton() {
        System.out.print("Нажата кнопка: ");
        currentCommand.execute();
        commandHistory.push(currentCommand);
    }

    public void pressUndoButton() {
        System.out.print("Нажата кнопка 'Отменить': ");
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("Нет команд для отмены.");
        }
    }
}
