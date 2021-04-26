package Prims;
import Data.*;
import Materials.*;

public class Mesh extends Obj {
    private Tri[] data;

    public Mesh(String name) {
        super(name);
    }

    public Mesh(String name, Mat material) {
        super(name, material);
    }

    public Mesh(String name, Tri[] data) {
        super(name);
        this.data = data;
    }

    public Mesh(String name, Tri[] data, Mat material) {
        super(name, material);
        this.data = data;
    }

    public void translate(Vec3 t) {
        center = Vec3.add(center, t);
        if (data != null && data.length > 0) {
            for (Tri tri : data) {
                tri.translate(t);
            }
        }
    }

    public double intersect(Ray ray) {
        Tri tc = new Tri();
        boolean hit = false;
        t = Double.POSITIVE_INFINITY;
        if (data == null || data.length == 0) return -1.0;

        for (Tri tri : data) {
            double t0 = tri.intersect(ray);
            if (t0 > 0.0001 && t0 < t) {
                t = t0;
                tc = tri;
                hit = true;
            }
        }

        if (hit) {
            N = tc.N();
            return t;
        }

        return -1.0;
    }
}