package Materials;
import Data.*;

public class Emit extends Mat {
    public Emit(String name) {
        super(name);
    }

    public Emit(String name, Vec3 color) {
        super(name, color);
    }

    public Emit(String name, double emission) {
        super(name);
        color = Vec3.mult(color, emission);
    }

    public Emit(String name, Vec3 color, double emission) {
        super(name, color);
        color = Vec3.mult(color, emission);
    }

    public boolean isEmissive() {
        return true;
    }

    public Ray scatter(Obj obj, Ray ray) {
        Vec3 p = ray.at(obj.t());
        return new Ray(p, Vec3.scatter(p, obj.N()));
    }
}
