package Shaders;
import Data.*;

public class Translucent extends Shader {
    private double rough;

    public Translucent(String n, double r) {
        super(n);
        rough = r;
    }

    public Translucent(String n, Vec3 c, double r) {
        super(n, c);
        rough = r;
    }

    public Ray scatter(Obj ob, Ray r) {
        Vec3 p = r.at(ob.t());
        return new Ray(p, Vec3.add(Vec3.add(p, r.direction()), Vec3.mult(Vec3.scatter(p, ob.N()), rough)));
    }
}