package org.example.behavioral.command.command;

import org.example.behavioral.command.systems.TV;

public class TurnOnTVCommand implements Command {
    private TV tv;

    public TurnOnTVCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}