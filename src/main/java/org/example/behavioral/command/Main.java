package org.example.behavioral.command;

import org.example.behavioral.command.command.AdjustVolumeCommand;
import org.example.behavioral.command.command.ChangeChannelCommand;
import org.example.behavioral.command.command.Command;
import org.example.behavioral.command.command.TurnOnTVCommand;
import org.example.behavioral.command.systems.StereoSystem;
import org.example.behavioral.command.systems.TV;

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
