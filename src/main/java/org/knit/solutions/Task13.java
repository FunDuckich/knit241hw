package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab4sem2.*;

@TaskDescription(taskNumber = 13, taskDescription = "Паттерн Command (Команда), Реализация системы команд для управления умным домом", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task13 implements Solution {
    @Override
    public void execute() {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light("Гостиная");
        Tv livingRoomTv = new Tv("Гостиная");
        Light kitchenLight = new Light("Кухня");

        Command lightOnLivingRoom = new LightOnCommand(livingRoomLight);
        Command lightOffLivingRoom = new LightOffCommand(livingRoomLight);
        Command tvOnLivingRoom = new TvOnCommand(livingRoomTv);
        Command tvOffLivingRoom = new TvOffCommand(livingRoomTv);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);


        System.out.println("--- Тест отдельных команд и отмены ---");
        remote.setCommand(lightOnLivingRoom);
        remote.pressButton();

        remote.setCommand(tvOnLivingRoom);
        remote.pressButton();

        System.out.println("Текущее состояние ТВ: " + (livingRoomTv.isOn() ? "Включен, канал " + livingRoomTv.getChannel() : "Выключен"));

        remote.pressUndoButton();
        System.out.println("Текущее состояние ТВ после отмены TvOn: " + (livingRoomTv.isOn() ? "Включен, канал " + livingRoomTv.getChannel() : "Выключен"));


        remote.setCommand(tvOnLivingRoom);
        remote.pressButton();

        remote.setCommand(tvOffLivingRoom);
        remote.pressButton();
        System.out.println("Текущее состояние ТВ после TvOff: " + (livingRoomTv.isOn() ? "Включен, канал " + livingRoomTv.getChannel() : "Выключен"));

        remote.pressUndoButton();
        System.out.println("Текущее состояние ТВ после отмены TvOff: " + (livingRoomTv.isOn() ? "Включен, канал " + livingRoomTv.getChannel() : "Выключен"));

        remote.pressUndoButton();
        System.out.println("Текущее состояние ТВ после второй отмены TvOn: " + (livingRoomTv.isOn() ? "Включен, канал " + livingRoomTv.getChannel() : "Выключен"));


        remote.pressUndoButton();
        remote.pressUndoButton();

        System.out.println("\n--- Тест макрокоманды 'Спокойной ночи' ---");
        remote.setCommand(lightOnLivingRoom);
        remote.pressButton();
        remote.setCommand(tvOnLivingRoom);
        remote.pressButton();
        remote.setCommand(kitchenLightOn);
        remote.pressButton();

        System.out.println("\nАктивация макрокоманды 'Спокойной ночи' (выключить все):");
        MacroCommand goodNightMacro = new MacroCommand(
                lightOffLivingRoom,
                new TvOffCommand(livingRoomTv),
                kitchenLightOff
        );
        remote.setCommand(goodNightMacro);
        remote.pressButton();

        System.out.println("\nОтмена макрокоманды 'Спокойной ночи':");
        remote.pressUndoButton();
        System.out.println("Состояние ТВ после отмены макро: " + (livingRoomTv.isOn() ? "Включен, канал " + livingRoomTv.getChannel() : "Выключен"));
    }
}
