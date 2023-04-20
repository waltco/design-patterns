
# Proxy Pattern 

**Proxy** is a structural design pattern that **lets you provide a substitute or placeholder for another object**. A proxy controls access to the original object, **allowing you to perform something either before or after the request gets through to the original object.**

The Proxy Pattern **can be used to add security or caching to an object**, to control access to a remote resource, or to defer the cost of creating an object until it is actually needed.

## Example:

Here's an example of the Proxy Pattern in Java:

```java
interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

class ProxyImage implements Image {
    private String filename;
    private RealImage image;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(filename);
        }
        image.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("test1.jpg");
        Image image2 = new ProxyImage("test2.jpg");

        // Image 1 will be loaded from disk
        image1.display();
        // Image 1 will be displayed from memory
        image1.display();
        // Image 2 will be loaded from disk
        image2.display();
        // Image 2 will be displayed from memory
        image2.display();
    }
}

```

In this example, we have an interface **`Image`** with two implementations: **`RealImage`** and **`ProxyImage`**. **`RealImage`** represents the actual image, while **`ProxyImage`** acts as a proxy to **`RealImage`**.

When a client requests to display an image, the proxy **`ProxyImage`** **first checks if the real image `RealImage` has been loaded**. **If the real image is not yet loaded, the proxy loads it from disk**. If the real image is already loaded, the proxy displays the image from memory.

The advantage of this pattern is that **it allows us to delay the loading of the actual image until it is actually needed, which can save on memory and processing time**. Additionally, the proxy can perform additional tasks before or after the request is forwarded to the real image.

For example, in this case, the proxy can display a placeholder image while the real image is loading from disk, or it could track the number of times each image is displayed.

## Benefits:

- **Security**: The proxy pattern **can provide a security layer around the real object**, ensuring that only authorized clients can access it.
    - In the example, the ImageProxy controls the access to the Image, and only when the image is needed, it is loaded into memory. This can prevent malicious or unintended use of the Image by limiting access to it.
- **Resource optimization**: **If the real object is expensive to create or requires a lot of resources to run, the proxy can delay its creation until it is really needed, or cache its results** to avoid repeated expensive calls.
    - In the example, the ImageProxy loads the image only when needed, and not before. This saves memory and processing resources, especially in scenarios where there are many images to be loaded.
- **Open/Closed Principle**: **You can introduce new proxies without changing the service or clients**.

## Cons:

- **Complexity**: The use of a proxy **can add complexity to the system, especially if multiple layers of proxies are used.**
- **Maintenance**: **The maintenance of the proxy and the underlying system can be challenging**, especially if changes need to be made to the interface or implementation.
- **Security**: **The use of a proxy can introduce security risks if the proxy is not properly implemented** or if it is not configured correctly.
- **Can introduce additional latency**: In the example, the ImageProxy may introduce some latency when loading the actual image, which can be a problem if fast loading times are critical to the user experience.
