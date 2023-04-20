package org.example.structural.facade;

import org.example.structural.facade.facade.VideoPlayerFacade;

public class Main {
    public static void main(String[] args) {
        VideoPlayerFacade player = new VideoPlayerFacade();
        player.play("myvideo.mp4");
    }
}
