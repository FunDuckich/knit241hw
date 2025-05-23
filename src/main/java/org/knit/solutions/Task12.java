package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab4sem2.EditorHistory;
import org.knit.solutions.lab4sem2.EditorMemento;
import org.knit.solutions.lab4sem2.TextEditor;

@TaskDescription(taskNumber = 12, taskDescription = "Паттерн Memento (Хранитель), Реализация системы отмены изменений в текстовом редакторе", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task12 implements Solution {

    @Override
    public void execute() {
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        System.out.println("--- Начало работы ---");
        editor.printCurrentText();

        System.out.println("\n--- Пользователь вводит текст ---");
        editor.type("Ку!");
        editor.printCurrentText();

        System.out.println("\n--- Сохранение состояния 1 ---");
        history.push(editor.saveStateToMemento());

        System.out.println("\n--- Пользователь добавляет текст ---");
        editor.type(" Читал README.md?");
        editor.printCurrentText();

        System.out.println("\n--- Сохранение состояния 2 ---");
        history.push(editor.saveStateToMemento());

        System.out.println("\n--- Пользователь добавляет еще текст ---");
        editor.type(" Не");
        editor.printCurrentText();

        System.out.println("\n--- Нажатие 'Отменить' (Undo 1) ---");
        EditorMemento memento1 = history.pop();
        editor.restoreStateFromMemento(memento1);
        editor.printCurrentText();

        System.out.println("\n--- Нажатие 'Отменить' (Undo 2) ---");
        EditorMemento memento2 = history.pop();
        editor.restoreStateFromMemento(memento2);
        editor.printCurrentText();

        System.out.println("\n--- Попытка отменить еще раз (история пуста) ---");
        EditorMemento memento3 = history.pop();
        if (memento3 == null) {
            System.out.println("История отмен пуста, нечего восстанавливать.");
        } else {
            editor.restoreStateFromMemento(memento3);
        }
        editor.printCurrentText();


        System.out.println("\n--- Ввод нового текста после отмен ---");
        editor.type("Как дела?");
        editor.printCurrentText();
        System.out.println("\n--- Сохранение состояния 3 ---");
        history.push(editor.saveStateToMemento());
        editor.type(" Супер!");
        editor.printCurrentText();
        System.out.println("\n--- Отмена последнего изменения ---");
        editor.restoreStateFromMemento(history.pop());
        editor.printCurrentText();
    }
}
