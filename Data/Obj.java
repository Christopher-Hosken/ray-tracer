package Data;
import Shaders.*;

public class Obj {
    protected String name;
    protected Vec3 center;
    protected double t;
    protected Vec3 N;
    protected boolean frontFacing;
    protected Shader mat;

    public Obj(String n, Shader m) {
        center = new Vec3();
        name = n;
        mat = m;
    }

    public Obj(String n, Vec3 c, Shader m) {
        center = c;
        name = n;
        mat = m;
    }

    public String name() {
        return name;
    }

    public Vec3 center() {
        return center;
    }

    public double t() {
        return t;
    }

    public Vec3 N() {
        return N;
    }

    public Shader mat() {
        return mat;
    }

    public double radius() {
        return 0.0;
    }

    public boolean isLight() {
        return false;
    }

    public boolean frontFacing() {
        return frontFacing;
    }

    public void setNormal(Ray r) {
        frontFacing = Vec3.dot(r.direction(), N) < 0;
        if (!frontFacing) {
            N = N.invert();
        }
    }

    public double intersect(Ray r) {
        return -1;
    }
}
