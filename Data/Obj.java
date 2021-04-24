package Data;

public class Obj {
    protected String name;
    protected Vec3 center;
    protected double t;
    protected Vec3 N;

    public Obj(String n) {
        center = new Vec3();
        name = n;
    }

    public Obj(String n, Vec3 c) {
        center = c;
        name = n;
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

    public double intersect(Ray r) {
        return -1;
    }
}
