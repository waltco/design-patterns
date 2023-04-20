# Facade Pattern

The Facade Pattern is a design pattern that **provides a simplified interface to a larger and more complex system of classes, interfaces, and object**s. It is a structural pattern that encapsulates the complexity of the system and provides a single, easy-to-use interface for the client. The Facade Pattern **is useful when there is a large system with many components and the client only needs to interact with a small subset of those components**

Suppose you are building a video player application and you have several subsystems such as video playback, audio playback, and subtitle rendering. You can use the Facade pattern to provide a simplified interface for the client to interact with these subsystems without worrying about their complexities.

Here's an example implementation:

```java
// VideoSubsystem.java
public class VideoSubsystem {
    public void playVideo(String filename) {
        System.out.println("Playing video: " + filename);
    }
}

// AudioSubsystem.java
public class AudioSubsystem {
    public void playAudio(String filename) {
        System.out.println("Playing audio: " + filename);
    }
}

// SubtitleSubsystem.java
public class SubtitleSubsystem {
    public void renderSubtitle(String filename) {
        System.out.println("Rendering subtitle: " + filename);
    }
}

// VideoPlayerFacade.java
public class VideoPlayerFacade {
    private VideoSubsystem videoSubsystem;
    private AudioSubsystem audioSubsystem;
    private SubtitleSubsystem subtitleSubsystem;

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

// Main.java
public class Main {
    public static void main(String[] args) {
        VideoPlayerFacade player = new VideoPlayerFacade();
        player.play("myvideo.mp4");
    }
}
```

In this example, the **`VideoPlayerFacade`** acts as a single entry point to the subsystems. It initializes the necessary subsystems in its constructor and provides a single **`play`** method to the client. When the **`play`** method is called, the facade internally calls the necessary methods on the subsystems to play the video with audio and subtitles. The client doesn't need to know anything about the individual subsystems and their complexities.

## Pros

1. **Code Isolation:** You can isolate your code from the complexity of a subsystem.

## Cons:

1. **Reduced control**: Because the Facade provides a simplified interface to the subsystems, it can also limit the control that clients have over the individual subsystems. Clients may not be able to access all of the functionality of the subsystems, which can be limiting in certain situations. .

   Example: The Facade provides a limited set of playback options (play, pause, stop). If a client wanted to adjust the volume, change the playback speed, or add subtitles, for example, they would need to access the underlying subsystems directly or modify the Facade to provide additional methods.