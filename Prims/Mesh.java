package Prims;
import Data.*;
import Shaders.*;

public class Mesh extends Obj {
    private Tri[] data;

    public Mesh(String n, Shader m) {
        super(n, m);
    }

    public Mesh(String n, Tri[] d, Shader m) {
        super(n, m);
        data = d;
    }

    public double intersect(Ray r) {
        Tri tc = new Tri();
        boolean hit = false;
        t = Double.POSITIVE_INFINITY;
        if (data == null || data.length == 0) return -1.0;

        for (Tri tri : data) {
            double t0 = tri.intersect(r);
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