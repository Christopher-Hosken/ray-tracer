package Shaders;
import Data.*;

public class Diffuse extends Shader {
    public Diffuse(String n) {
        super(n);
    }

    public Diffuse(String n, Vec3 c) {
        super(n, c);
    }

    public Ray scatter(Obj ob, Ray r) {
        Vec3 p = r.at(ob.t());
        return new Ray(p, Vec3.scatter(p, ob.N()));
    }
}
