package Materials;
import Data.*;

public class Mat {
    protected String name;
    protected Vec3 color;
    protected double spec;

    public Mat(String name) {
        this.name = name;
        color = new Vec3(1, 1, 1);
        spec = 0.5;
    }

    public Mat(String name, Vec3 color) {
        this.name = name;
        this.color = color;
        spec = 0.5;
    }

    public Mat(String name, Vec3 color, double spec) {
        this.name = name;
        this.color = color;
        this.spec = spec;
    }

    public Vec3 color() {
        return color;
    }

    public double spec() {
        return spec;
    }

    public boolean isEmissive() {
        return false;
    }

    public Ray scatter(Obj obj, Ray ray) {
        return new Ray(ray.at(obj.t()), obj.N());
    }
}