import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Camera cam = new Camera(480, 480);
        cam.render(512);
    }
}