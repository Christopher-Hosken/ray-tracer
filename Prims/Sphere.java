package Prims;
import Data.*;
import Materials.*;

public class Sphere extends Obj {
    private double radius;

    public Sphere(String name) {
        super(name);
        radius = 1;
    }

    public Sphere(String name, Mat material) {
        super(name, material);
        radius = 1;
    }

    public Sphere(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public Sphere(String name, Vec3 center) {
        super(name, center);
    }

    public Sphere(String name, Vec3 center, double radius) {
        super(name, center);
        this.radius = radius;
    }

    public Sphere(String name, Vec3 center, Mat material) {
        super(name, center, material);
    }

    public Sphere(String name, double radius, Mat material) {
        super(name, material);
        this.radius = radius;
    }

    public Sphere(String name, Vec3 center, double radius, Mat material) {
        super(name, center, material);
        this.radius = radius;
    }

    public double radius() {
        return radius;
    }

    public void scale(double s) {
        radius = radius * s;
    }

    public double intersect(Ray ray) {
        Vec3 oc = Vec3.sub(ray.origin(), center);
        double a = ray.direction().lengthSquared();
        double halfB = Vec3.dot(oc, ray.direction());
        double c = oc.lengthSquared() - radius * radius;
        double disc = halfB * halfB - a * c;

        if (disc < 0) return -1.0;
        disc = Math.sqrt(disc);

        double t0 = (-halfB - disc) / a;
        double t1 = (-halfB + disc) / a;

        if (t0 < 0) {
            if (t1 < 0) return -1;
            t = t1;
        }
        else if (t1 < 0){
            t = t0;
        }
        else {
            t = t1;
            if (t0 < t1) t = t0;
        }

        N = Vec3.div(Vec3.sub(ray.at(t), center), radius);
        setNormal(ray);

        return t;
    }
}