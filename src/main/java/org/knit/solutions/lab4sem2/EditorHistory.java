package org.knit.solutions.lab4sem2;

import java.util.Stack;

public class EditorHistory {
    private final Stack<EditorMemento> history;

    public EditorHistory() {
        this.history = new Stack<>();
    }

    public void push(EditorMemento memento) {
        history.push(memento);
    }

    public EditorMemento pop() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
