package Prims;
import Data.*;

public class Mesh extends Obj {
    private Tri[] data;

    public Mesh(String name) {
        super(name);
    }

    public Mesh(String name, Tri[] data) {
        super(name);
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
            if (t0 > 0.0000001 && t0 < t) {
                t = t0;
                tc = tri;
                hit = true;
            }
        }

        if (hit) {
            N = tc.N();
            if (Vec3.dot(ray.direction(), N) > 0) {
                N = N.invert();
                frontFacing = false;
            }
            else {
                frontFacing = true;
            }
            return t;
        }

        return -1.0;
    }
}