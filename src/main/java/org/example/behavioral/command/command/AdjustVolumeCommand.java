package org.example.behavioral.command.command;

import org.example.behavioral.command.systems.StereoSystem;

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
