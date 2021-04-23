public class Mesh extends Obj {
    private Tri[] data;

    public Mesh() {
        super();
    }

    public Mesh(Vec3 c, Tri[] d) {
        super(c);
        data = d;
    }

    public double intersect(Ray r) {
        double t = Double.POSITIVE_INFINITY;
        return t;
    }
}
