public class Sphere extends Obj {
    private double radius;

    public Sphere() {
        super();
        radius = 1;
    }

    public Sphere(String n) {
        super(n);
        radius = 1;
    }

    public Sphere(Vec3 c, double r) {
        super(c);
        radius = r;
    }

    public Sphere(String n, Vec3 c, double r) {
        super(n, c);
        radius = r;
    }

    public double intersect(Ray r) {
        Vec3 oc = Vec3.sub(r.origin(), center);
        double a = r.direction().lengthSquared();
        double b = 2 * (Vec3.dot(r.direction(), oc));
        double c = oc.lengthSquared() - radius*radius;
        double disc = b*b - 4*a*c;

        if (disc < 0) return -1.0;

        disc = Math.sqrt(disc);

        double p1 = (-b + disc) / 2;
        double p2 = (-b - disc) / 2;

        if (p1 < p2) return p1;
        return p2;
    }
}