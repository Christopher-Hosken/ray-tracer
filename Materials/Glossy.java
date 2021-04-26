package Materials;
import Data.*;

public class Glossy extends Mat {
    private double roughness;

    public Glossy(String name) {
        super(name);
        this.roughness = 0;
    }

    public Glossy(String name, double roughness) {
        super(name);
        this.roughness = roughness;
    }

    public Glossy(String name, Vec3 color, double roughness) {
        super(name, color);
        this.roughness = roughness;
    }

    public Ray scatter(Obj ob, Ray ray) {
        Vec3 p = ray.at(ob.t());
        return new Ray(
            p,
            Vec3.reflect(ray.direction(), ob.N(), roughness)
        );
    }
}