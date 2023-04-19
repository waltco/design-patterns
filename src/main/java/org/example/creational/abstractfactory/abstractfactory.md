# Abstract Factory Pattern

Abstract Factory is a creational design pattern that **allows the creation of families of related objects without specifying their concrete classes**. It is an extension of the Factory Method pattern, which creates objects of a single type, while the Abstract Factory creates objects of multiple types.

```java
// Abstract ProductA
interface Window {
    void setTitle(String title);
    void paint();
}

// Concrete ProductA1
class MacOSWindow implements Window {
    private String title;

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void paint() {
        System.out.println("Painting a MacOS window with title: " + title);
    }
}

// Concrete ProductA2
class WindowsWindow implements Window {
    private String title;

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void paint() {
        System.out.println("Painting a Windows window with title: " + title);
    }
}

// Abstract ProductB
interface Button {
    void setText(String text);
    void click();
}

// Concrete ProductB1
class MacOSButton implements Button {
    private String text;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void click() {
        System.out.println("Clicked a MacOS button with text: " + text);
    }
}

// Concrete ProductB2
class WindowsButton implements Button {
    private String text;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void click() {
        System.out.println("Clicked a Windows button with text: " + text);
    }
}

// Abstract Factory
interface GUIFactory {
    Window createWindow();
    Button createButton();
}

// Concrete Factory 1
class MacOSFactory implements GUIFactory {
    @Override
    public Window createWindow() {
        return new MacOSWindow();
    }

    @Override
    public Button createButton() {
        return new MacOSButton();
    }
}

// Concrete Factory 2
class WindowsFactory implements GUIFactory {
    @Override
    public Window createWindow() {
        return new WindowsWindow();
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

// Client Code
class Application {
    private GUIFactory factory;
    private Window window;
    private Button button;

    public Application(GUIFactory factory) {
        this.factory = factory;
        this.window = factory.createWindow();
        this.button = factory.createButton();
    }

    public void run() {
        window.setTitle("My App");
        window.paint();
        button.setText("Click me");
        button.click();
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        GUIFactory factory = new MacOSFactory(); // or new WindowsFactory()
        Application app = new Application(factory);
        app.run();
    }
}

```

In this example, we have two abstract products: **`Window`** and **`Button`**. We also have two concrete implementations of each of these products for two different operating systems: **`MacOSWindow`**, **`WindowsWindow`**, **`MacOSButton`**, and **`WindowsButton`**.

We then have an abstract factory interface **`GUIFactory`**, which has two factory methods: **`createWindow`** and **`createButton`**. We also have two concrete implementations of the **`GUIFactory`** interface for two different operating systems: **`MacOSFactory`** and **`WindowsFactory`**.

Finally, we have a client class **`Application`** that takes in a **`GUIFactory`** in its constructor and creates a **`Window`** and **`Button`** using the factory. The **`Application`** class then uses these objects to perform some actions.