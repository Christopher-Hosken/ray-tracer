package Materials;
import Data.*;

public class Translucent extends Mat {
    private double roughness;

    public Translucent(String name) {
        super(name);
        this.roughness = 0;
    }

    public Translucent(String name, double roughness) {
        super(name);
        this.roughness = roughness;
    }

    public Translucent(String name, Vec3 color, double roughness) {
        super(name, color);
        this.roughness = roughness;
    }

    public Ray scatter(Obj obj, Ray ray) {
        Vec3 p = ray.at(obj.t());
        return new Ray(p, Vec3.add(Vec3.add(p, ray.direction()), Vec3.mult(Vec3.scatter(p, obj.N()), roughness)));
    }
}