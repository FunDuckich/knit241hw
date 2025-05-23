package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab5sem2.CharacterFactory;
import org.knit.solutions.lab5sem2.TextEditor;

@TaskDescription(taskNumber = 16, taskDescription = "паттерн Приспособленец (Flyweight), Реализуйте систему отображения символов текста на экране.", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task16 implements Solution {
    @Override
    public void execute() {
        CharacterFactory factory = new CharacterFactory();
        TextEditor editor = new TextEditor(factory);

        System.out.println("--- Добавление символов в редактор ---");

        // Добавляем "Hello"
        editor.addCharacter('H', 10, 10, "Arial-12-Bold");
        editor.addCharacter('e', 20, 10, "Arial-12-Normal");
        editor.addCharacter('l', 30, 10, "Arial-12-Normal");
        editor.addCharacter('l', 40, 10, "Arial-12-Normal");
        editor.addCharacter('o', 50, 10, "Arial-12-Normal");

        editor.addCharacter(' ', 60, 10, "Arial-12-Normal");

        // Добавляем "World"
        editor.addCharacter('W', 70, 10, "TimesNewRoman-14-Bold");
        editor.addCharacter('o', 80, 10, "TimesNewRoman-14-Normal");
        editor.addCharacter('r', 90, 10, "TimesNewRoman-14-Normal");
        editor.addCharacter('l', 100, 10, "TimesNewRoman-14-Normal");
        editor.addCharacter('d', 110, 10, "TimesNewRoman-14-Normal");

        editor.renderAll();

        System.out.println("\n--- Добавление еще одного символа 'l' с другим стилем ---");
        editor.addCharacter('l', 50, 50, "Courier-10-Italic");
        editor.renderAll();

        System.out.println("\n--- Добавление нового символа '!' ---");
        editor.addCharacter('!', 120, 10, "Arial-12-Bold");
        editor.renderAll();
    }
}
