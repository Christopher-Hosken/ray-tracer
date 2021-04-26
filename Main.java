import java.io.*;

import Data.*;
import Materials.*;
import Prims.*;

public class Main {
    public double epsilon = 0.0000001;
    public static void main(String args[]) throws IOException {
        World scene = new World();

        Mat diffuseMat = new Diffuse("mat1", new Vec3(1,1,1));
        Mat glossyMat = new Glossy("mat2", new Vec3(1,1,1), 0);
        Mat emitMat = new Emit("mat3", new Vec3(1,1,1), 1.5);
        Mat transMat = new Translucent("mat4", new Vec3(1,1,1), 0.2);

        scene.add(new Sphere("ground", new Vec3(0, -100.5, 1), 100, diffuseMat));

        scene.add(new Sphere("ball", new Vec3(), 1, glossyMat));

        scene.add(new PointLight("light", new Vec3(-20, 20, 1), 10, 25));

        Vec3 og = new Vec3(3, 10, -5);
        Vec3 look = new Vec3(0, 0, 1);

        double dis = Vec3.distance(og, look);

        Camera cam = new Camera(240, 240, og, look, 75, 0, 1, dis);
        cam.render(128, 4, scene);
    }
}