import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        World scene = new World();

        scene.add(
            new Mesh("mesh",
                new Tri[] {
                    new Tri(new Vec3(-0.25, 0.25, 1), new Vec3(0, 0, 1), new Vec3(0.25, 0.25, 1)),
                    new Tri(new Vec3(-0.25, 0.25, 1), new Vec3(3, 0, 1), new Vec3(0.25, 0.25, 1)),
                }
            )
        );

        Camera cam = new Camera(240, 240);
        cam.render(8, 4, scene);
    }
}