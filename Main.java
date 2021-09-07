import java.io.*;

import data.*;
import data.base.*;
import data.objects.*;
import data.objects.objs.*;
import data.objects.primitives.*;
import data.shaders.*;

public class Main {
    public double epsilon = 0.0000001;
    public static void main(String args[]) throws IOException {
        world scene = new world();

        shader dif = new diffuse(new vec3(1, 1, 1), 0.75);

        scene.add(new sphere("sph", 1));

        //scene.add(new importobject("obj", new File("data/objects/objs/suzanne.obj"), dif));

        vec3 og = new vec3(3, 1, 3);
        vec3 look = new vec3(0, 0, 0);

        double dis = vec3.distance(og, look);

        camera cam = new camera(256, 256, og, look, 75, 0, 1, dis);
        cam.render(scene, 12, 12);
    }
}