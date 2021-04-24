package Prims;
import Data.*;

public class Sphere extends Obj {
    private double radius;

    public Sphere(String n) {
        super(n);
        radius = 1;
    }

    public Sphere(String n, Vec3 c, double r) {
        super(n, c);
        radius = r;
    }

    public double intersect(Ray r) {
        Vec3 oc = Vec3.sub(r.origin(), center);
        double a = r.direction().lengthSquared();
        double b = 2 * Vec3.dot(oc, r.direction());
        double c = oc.lengthSquared() - radius * radius;
        double disc = b*b - 4*a*c;

        if (disc < 0) return -1.0;
        disc = Math.sqrt(disc);

        double t0 = (-b - disc) / (2*a);
        double t1 = (-b + disc) / (2*a);

        if (t0 < 0 && t1 < 0) return -1.0;
        if (t0 < 0) t = t1;
        else if (t1 < 0) t = t0;
        else {
            t = t1;
            if (t0 < t1) t = t0;
        }

        N = Vec3.div(Vec3.sub(r.at(t), center), radius);

        return t;
    }
}