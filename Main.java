import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        World scene = new World();

        scene.add(
            new Sphere("ground", new Vec3(0, -100.5, 1), 100)
        );

        scene.add(
            new Sphere("sphere1", new Vec3(0, 0, 1), 0.5)
        );

        Camera cam = new Camera(240, 240);
        cam.render(512, 8, scene);
    }
}