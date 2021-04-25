package Shaders;
import Data.*;

public class Glossy extends Shader {
    private double rough;

    public Glossy(String n, double r) {
        super(n);
        rough = r;
    }

    public Glossy(String n, Vec3 c, double r) {
        super(n, c);
        rough = r;
    }

    public Ray scatter(Obj ob, Ray ray) {
        Vec3 p = ray.at(ob.t());
        return new Ray(
            p,
            Vec3.reflect(ray.direction(), ob.N(), rough)
        );
    }
}