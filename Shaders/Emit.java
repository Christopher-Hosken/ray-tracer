package Shaders;
import Data.*;

public class Emit extends Shader {
    public Emit(String n, double s) {
        super(n);
        color = Vec3.mult(color, s);
    }

    public Emit(String n, Vec3 c, double s) {
        super(n, c);
        color = Vec3.mult(color, s);
    }

    public boolean isEmissive() {
        return true;
    }

    public Ray scatter(Obj ob, Ray r) {
        Vec3 p = r.at(ob.t());
        return new Ray(p, Vec3.scatter(p, ob.N()));
    }
}
