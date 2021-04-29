import java.io.*;
import Data.*;
import Prims.*;

public class Main {
    public double epsilon = 0.0000001;
    public static void main(String args[]) throws IOException {
        World scene = new World();

        Vec3 og = new Vec3(0, 0, 0);
        Vec3 look = new Vec3(0, 1, 0);

        double dis = Vec3.distance(og, look);

        Camera cam = new Camera(240, 240, og, look, 75, 0, 1, dis);
        cam.render(scene, 128);
    }
}