package org.example.structural.proxy;

public class Main {
    public static void main(String[] args) {
        Image proxyImage = new ProxyImage("image.jpg");
        proxyImage.display(); // loaded from disk
        proxyImage.display(); // displayed from memory
    }
}
