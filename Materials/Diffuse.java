package Materials;
import Data.*;

public class Diffuse extends Mat {
    public Diffuse(String name) {
        super(name);
    }

    public Diffuse(String name, Vec3 color) {
        super(name, color);
    }

    public Diffuse(String name, Vec3 color, double spec) {
        super(name, color, spec);
    }

    public Ray scatter(Obj obj, Ray ray) {
        Vec3 p = ray.at(obj.t());
        return new Ray(p, Vec3.scatter(p, obj.N()));
    }
}