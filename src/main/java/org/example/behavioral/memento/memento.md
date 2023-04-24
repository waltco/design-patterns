Memento is a behavioral design pattern that **lets you save and restore the previous state of an object without revealing the details of its implementation.**

In the Memento pattern, an object (called the **Originator**) that **has an internal state creates a Memento object that contains a snapshot of its current state**. **This Memento object is then stored by another object (called the Caretaker)**, which can later restore the original state of the Originator by providing the saved Memento object.

The Memento pattern is **useful in situations where an object needs to be able to return to a previous state or undo a series of actions**

## Example

Let's consider a scenario where we have a text editor and we want to implement the "Undo" functionality. In order to implement this feature, we need to save the state of the editor before any changes are made, so that we can revert back to the previous state if needed. This is where the Memento pattern comes in.

First, we define a Memento class to store the state of the text editor:

```java
public class TextEditorMemento {
    private final String state;

    public TextEditorMemento(String stateToSave) {
        state = stateToSave;
    }

    public String getSavedState() {
        return state;
    }
}
```

Next, we define the Originator class which is the object whose state we want to save and restore:

```java
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
```

Finally, we create a caretaker class to manage the saved states of the text editor:

```java
public class TextEditorCaretaker {
    private final List<TextEditorMemento> mementoList = new ArrayList<>();

    public void addMemento(TextEditorMemento memento) {
        mementoList.add(memento);
    }

    public TextEditorMemento getMemento(int index) {
        return mementoList.get(index);
    }
}
```

Now, let's see how this would work in practice. First, we create a new instance of the text editor and set its state:

```java
TextEditorOriginator editor = new TextEditorOriginator();
editor.setState("Hello world");
```

Next, we create a caretaker object and save the current state of the text editor:

```java
TextEditorCaretaker caretaker = new TextEditorCaretaker();
caretaker.addMemento(editor.save());
```

We can now modify the state of the text editor:

```java
editor.setState("Goodbye world");
caretaker.addMemento(editor.save());
```

And if we want to revert back to the previous state, we can do so by restoring the saved state:

```java
editor.restore(caretaker.getMemento(0));
```

And that's it! The Memento pattern allows us to easily save and restore the state of an object without exposing its internal details.

## Pros

1. Encapsulates and **maintains the internal state of an object without violating encapsulation**.
    1. The Memento pattern allows the TextEditorOriginator to save its state and restore it later, without violating the encapsulation principle.
2. Provides a way to store and restore the state of an object at different points in time.
3. Simplifies the undo/redo functionality by providing a way to undo the changes made to an object.
4. Makes the code more modular and easier to maintain by separating the state management code from the main business logic.
    1. The Memento pattern helps to keep the TextEditor class focused on its main functionality, without adding the responsibility of state management to the class.

## Cons:

1. **Can increase memory usage** if the state of an object is large or if there are many states to store.
2. **Can make the code more complex** if not used properly.