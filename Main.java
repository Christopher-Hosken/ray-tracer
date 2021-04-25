import java.io.*;

import Shaders.*;
import Data.*;
import Prims.*;

public class Main {
    public static void main(String args[]) throws IOException {
        World scene = new World();

        scene.add(
            new Sphere("ground", new Vec3(0, -100.5, 1), 100, new Diffuse("mat1", new Vec3(1, 1, 1)))
        );

        scene.add(
            new Sphere("ball", new Vec3(0, 0, 1), 0.5, new Glossy("mat2", new Vec3(0.2, 1, 1), 0.1))
        );

        Vec3 og = new Vec3(3, 10, -5);
        Vec3 look = new Vec3(0, 0, 1);

        double dis = Vec3.distance(og, look);

        Camera cam = new Camera(240, 240, og, look, 75, 1, 1, dis);
        cam.render(128, 24, scene);
    }
}