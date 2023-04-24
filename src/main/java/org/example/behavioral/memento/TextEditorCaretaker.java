package org.example.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class TextEditorCaretaker {
    private final List<TextEditorMemento> mementoList = new ArrayList<>();

    public void addMemento(TextEditorMemento memento) {
        mementoList.add(memento);
    }

    public TextEditorMemento getMemento(int index) {
        return mementoList.get(index);
    }
}