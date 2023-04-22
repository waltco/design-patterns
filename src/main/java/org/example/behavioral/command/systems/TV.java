package org.example.behavioral.command.systems;

public class TV {
    public void turnOn(){
        System.out.println("Turning on tv ...");
    }

    public void changeChannel(int channel){
        System.out.println("Changing channel to " + channel);
    }
}
