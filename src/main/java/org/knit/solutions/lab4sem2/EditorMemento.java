package org.knit.solutions.lab4sem2;

public class EditorMemento {
    private final String textState;

    public EditorMemento(String textToSave) {
        this.textState = textToSave;
    }

    public String getSavedText() {
        return textState;
    }
}
