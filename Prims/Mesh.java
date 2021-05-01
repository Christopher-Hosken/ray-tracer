package Prims;
import Data.*;
import Materials.*;

public class Mesh extends Obj {
    private Face[] data;

    public Mesh(String name) {
        super(name);
    }

    public Mesh(String name, Face[] data) {
        super(name);
        this.data = data;
    }

    public Mesh(String name, Face[] data, Mat mat) {
        super(name);
        this.data = data;
        this.mat = mat;
    }

    public double intersect(Ray ray) {
        boolean hit = false;
        String s = "";
        t = Double.POSITIVE_INFINITY;
        if (data == null || data.length == 0) return -1.0;

        for (Face face : data) {
            double t0 = face.intersect(ray);
            if (t0 > 0.0000001 && t0 < t) {
                s = face.id();
                t = t0;
                N = face.N();
                hit = true;
            }
        }

        if (hit) {
            if (invN) {
                N = N.invert();
            }
            return t;
        }

        return -1;
    }
}