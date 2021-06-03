import java.io.*;
import Data.*;
import Prims.*;
import Materials.*;

public class Main {
    public double epsilon = 0.0000001;
    public static void main(String args[]) throws IOException {
        World scene = new World();

        Mat dif = new Diffuse("dif", new Vec3(1, 1, 1));
        Mat glos = new Glossy("glos", new Vec3(1, 1, 1), 0.1, 0.65);

        scene.add(Primitives.Cube("cube", dif));
        scene.get("cube").InvertNormal();
        scene.add(Primitives.IcoSphere("ico", glos));

        scene.add(new Mesh("ground", 
        new Face[] { 
            new Face("f1", 
            new Vec3(-3, -0.5, 3), 
            new Vec3(3, -0.5, 3),
            new Vec3(3, -0.5, -3), 
            new Vec3(-3, -0.5, -3)
            )
        }, dif));

        scene.add(new Mesh("wall",
        new Face[] {
            new Face("f2", 
            new Vec3(-3, 3.5, 3),
            new Vec3(3, 3.5, 3),
            new Vec3(3, -0.5, 3),
            new Vec3(-3, -0.5, 3)
            )
        }, dif));

        scene.get("wall").InvertNormal();

        Vec3 og = new Vec3(-5, 4, -3);
        Vec3 look = new Vec3(0, 0, 0);

        double dis = Vec3.distance(og, look);

        Camera cam = new Camera(240, 240, og, look, 75, 0, 1, dis);
        cam.render(scene, 128, 4);
    }
}