package Prims;
import Data.*;

public class Mesh extends Obj {
    private Face[] data;

    public Mesh(String name) {
        super(name);
    }

    public Mesh(String name, Face[] data) {
        super(name);
        this.data = data;
    }

    public double intersect(Ray ray) {
        boolean hit = false;
        t = Double.POSITIVE_INFINITY;
        if (data == null || data.length == 0) return -1.0;

        for (Face face : data) {
            double t0 = face.intersect(ray);
            if (t0 < t && t0 > 0) {
                t = t0;
                N = face.N();
                hit = true;
            }
        }

        if (hit) {
            return t;
        }

        return -1;
    }
}