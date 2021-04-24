import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Camera cam = new Camera(240, 240);
        cam.render(512);
    }
}