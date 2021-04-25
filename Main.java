import java.io.*;

import Shaders.*;
import Data.*;
import Prims.*;

public class Main {
    public double epsilon = 0.0000001;
    public static void main(String args[]) throws IOException {
        World scene = new World();

        scene.add(
            new Sphere("ground", new Vec3(0, -100.5, 1), 100, new Diffuse("mat1", new Vec3(1, 1, 1)))
        );

        scene.add(
            new Mesh("mesh", new Tri[] {
                new Tri(
                    new Vec3(1, 3, 1),
                    new Vec3(-1, 3, 1),
                    new Vec3(0, 3, -1)
                )
            }, new Diffuse("mat2", new Vec3(0.5, 0.5, 1)))
        );

        Vec3 og = new Vec3(3, 10, -5);
        Vec3 look = new Vec3(0, 0, 1);

        double dis = Vec3.distance(og, look);

        Camera cam = new Camera(240, 240, og, look, 75, 0, 1, dis);
        cam.render(128, 4, scene);
    }
}