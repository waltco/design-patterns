package org.example.behavioral.memento;

public class Main {

    public static void main(String[] args) {
        TextEditorOriginator editor = new TextEditorOriginator();
        editor.setState("Hello world");

        TextEditorCaretaker caretaker = new TextEditorCaretaker();
        caretaker.addMemento(editor.save());

        editor.setState("Goodbye world");
        caretaker.addMemento(editor.save());

        editor.restore(caretaker.getMemento(1));
        System.out.println("editor.getState() = " + editor.getState());

    }
}
