package org.knit.solutions.lab4sem2;

import java.util.List;
import java.util.Arrays;

public class MacroCommand implements Command {
    private final List<Command> commands;

    public MacroCommand(List<Command> commands) {
        this.commands = commands;
    }

    public MacroCommand(Command... commands) {
        this.commands = Arrays.asList(commands);
    }

    @Override
    public void execute() {
        System.out.println("--- Выполнение макрокоманды ---");
        for (Command command : commands) {
            command.execute();
        }
        System.out.println("--- Макрокоманда завершена ---");
    }

    @Override
    public void undo() {
        System.out.println("--- Отмена макрокоманды ---");
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
        System.out.println("--- Отмена макрокоманды завершена ---");
    }
}
