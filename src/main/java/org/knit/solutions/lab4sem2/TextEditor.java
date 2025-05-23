package org.knit.solutions.lab4sem2;

public class TextEditor {
    private StringBuilder currentText;

    public TextEditor() {
        this.currentText = new StringBuilder();
    }

    public void type(String text) {
        this.currentText.append(text);
        System.out.println("Добавлен текст: \"" + text + "\"");
    }

    public void printCurrentText() {
        System.out.println("Текущий текст: \"" + this.currentText.toString() + "\"");
    }

    public EditorMemento saveStateToMemento() {
        return new EditorMemento(this.currentText.toString());
    }

    public void restoreStateFromMemento(EditorMemento memento) {
        if (memento != null) {
            this.currentText = new StringBuilder(memento.getSavedText());
        } else {
            System.out.println("Нечего восстанавливать.");
        }
    }
}
