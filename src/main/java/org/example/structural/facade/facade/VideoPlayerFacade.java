package org.example.structural.facade.facade;

import org.example.structural.facade.subsystem.AudioSubsystem;
import org.example.structural.facade.subsystem.SubtitleSubsystem;
import org.example.structural.facade.subsystem.VideoSubsystem;

public class VideoPlayerFacade {
    private final VideoSubsystem videoSubsystem;
    private final AudioSubsystem audioSubsystem;
    private final SubtitleSubsystem subtitleSubsystem;

    public VideoPlayerFacade() {
        videoSubsystem = new VideoSubsystem();
        audioSubsystem = new AudioSubsystem();
        subtitleSubsystem = new SubtitleSubsystem();
    }

    public void play(String filename) {
        videoSubsystem.playVideo(filename);
        audioSubsystem.playAudio(filename);
        subtitleSubsystem.renderSubtitle(filename);
    }
}
