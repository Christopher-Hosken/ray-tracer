public class Obj {
    protected String name;
    protected Vec3 center;

    public Obj() {
        center = new Vec3();
        name = "";
    }

    public Obj(String n) {
        center = new Vec3();
        name = n;
    }

    public Obj(Vec3 c) {
        center = c;
        name = "";
    }

    public Obj(String n, Vec3 c) {
        center = c;
        name = n;
    }

    public Vec3 center() {
        return center;
    }

    public double intersect() {
        return 0.0;
    }
}
