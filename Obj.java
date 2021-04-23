public class Obj {
    protected Vec3 center;

    public Obj() {
        center = new Vec3();
    }

    public Obj(Vec3 c) {
        center = c;
    }

    public Vec3 center() {
        return center;
    }

    public double intersect() {
        return 0.0;
    }
}
