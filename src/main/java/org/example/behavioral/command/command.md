# Command Pattern

**Command** is a **behavioral design pattern that turns a request into a stand-alone object that contains all information about the request**. This transformation **lets you pass requests as a method arguments, delay or queue a request’s execution**, and support undoable operations.

In simple terms, the Command pattern **is a way of encapsulating a request in the form of an objec**t. This object can then be used to perform the request, log the request, or even undo the request at a later time

## Example

Suppose you have a remote control that can operate multiple devices, such as a TV, a stereo system, and a DVD player. You want to be able to program the remote control with a list of commands, such as turning on the TV, changing the channel, and adjusting the volume. You can use the Command pattern to encapsulate each of these actions as a command object, which can then be added to a list and executed in order.

Here's how the code might look like:

First, let's define the command interface that all command objects will implement:

```java
public interface Command {
    void execute();
}
```

Next, let's define some concrete command classes:

```java
public class TurnOnTVCommand implements Command {
    private TV tv;

    public TurnOnTVCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}

public class ChangeChannelCommand implements Command {
    private TV tv;
    private int channel;

    public ChangeChannelCommand(TV tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    public void execute() {
        tv.changeChannel(channel);
    }
}

public class AdjustVolumeCommand implements Command {
    private StereoSystem stereo;
    private int volume;

    public AdjustVolumeCommand(StereoSystem stereo, int volume) {
        this.stereo = stereo;
        this.volume = volume;
    }

    public void execute() {
        stereo.adjustVolume(volume);
    }
}

public class TV {
    public void turnOn(){
        System.out.println("Turning on tv ...");
    }

    public void changeChannel(int channel){
        System.out.println("Changing channel to " + channel);
    }
}

public class StereoSystem {
    public void adjustVolume(int volume) {
        System.out.println("Adjusting Stereo volume to " + volume);
    }
}
```

Note that each command class takes in the necessary device object(s) as parameters and implements the **`execute()`** method to perform the corresponding action.

Now, let's create a list of command objects and execute them in order:

```java
public class RemoteControl {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
    }
}

```

Here, **`RemoteControl`** maintains a list of **`Command`** objects and provides methods to add commands to the list and execute them in order.

Finally, let's create some device objects and test out the remote control:

```java
public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        StereoSystem stereo = new StereoSystem();

        Command turnOnTVCommand = new TurnOnTVCommand(tv);
        Command changeChannelCommand = new ChangeChannelCommand(tv, 5);
        Command adjustVolumeCommand = new AdjustVolumeCommand(stereo, 10);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.addCommand(turnOnTVCommand);
        remoteControl.addCommand(changeChannelCommand);
        remoteControl.addCommand(adjustVolumeCommand);

        remoteControl.executeCommands();
    }
}

```

This code creates a **`TV`** and a **`StereoSystem`** object, as well as three **`Command`** objects for turning on the TV, changing the channel to 5, and adjusting the volume to 10 on the stereo system. These commands are then added to a **`RemoteControl`** object and executed in order. When **`executeCommands()`** is called, the TV will turn on, the channel will change to 5, and the volume on the stereo system will be adjusted to 10.

## Pros

- The Command pattern **separates the object that invokes the operation from the object that knows how to perform it**, which can improve the decoupling of the system and make it more flexible.
- It **allows you to add new commands to the system without changing the existing code**, which makes the system more extensible.
- The pattern **enables the creation of complex commands that are composed of smaller, more modular commands**, which can increase the reuse of code and simplify testing.

## Cons

- The Command pattern **can result in a large number of classes if you have a lot of commands**, which can make the system more difficult to understand and maintain.
- It can also **introduce some additional overhead in terms of memory usage and performance**, since each command object requires additional memory and CPU cycles to execute.
- In some cases, the Command pattern may not be the most appropriate design pattern for the problem at hand. It is important to consider other patterns and factors, such as the system's performance and complexity, before deciding to use the Command pattern