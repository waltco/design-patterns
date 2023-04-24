package org.example.behavioral.memento;

public class TextEditorMemento {
    private final String state;

    public TextEditorMemento(String stateToSave) {
        state = stateToSave;
    }

    public String getSavedState() {
        return state;
    }
}