package org.example.behavioral.memento;

public class TextEditorOriginator {
    private String state;

    public void setState(String newState) {
        state = newState;
    }

    public String getState() {
        return state;
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(state);
    }

    public void restore(TextEditorMemento memento) {
        state = memento.getSavedState();
    }
}