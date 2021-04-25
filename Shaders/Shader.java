package Shaders;
import Data.*;

public class Shader {
    protected String name;
    protected Vec3 color;

    public Shader(String n) {
        name = n;
        color = new Vec3(1, 1, 1);
    }

    public Shader(String n, Vec3 c) {
        name = n;
        color = c;
    }

    public Vec3 color() {
        return color;
    }

    public boolean isEmissive() {
        return false;
    }

    public Ray scatter(Obj ob, Ray r) {
        return new Ray(r.at(ob.t()), ob.N());
    }
}