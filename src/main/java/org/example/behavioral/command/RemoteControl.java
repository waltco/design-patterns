package org.example.behavioral.command;

import org.example.behavioral.command.command.Command;

import java.util.ArrayList;
import java.util.List;

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
