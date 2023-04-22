package org.example.behavioral.command.command;

import org.example.behavioral.command.systems.TV;

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
